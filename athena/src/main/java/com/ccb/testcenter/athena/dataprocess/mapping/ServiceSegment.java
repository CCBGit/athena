package com.ccb.testcenter.athena.dataprocess.mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.dom4j.Element;

import com.ccb.testcenter.athena.AthenaConstants;
import com.ccb.testcenter.athena.dataprocess.entity.Field;
import com.ccb.testcenter.athena.dataprocess.entity.Group;
import com.ccb.testcenter.athena.dataprocess.entity.Item;
import com.ccb.testcenter.athena.dataprocess.entity.Rule;
import com.ccb.testcenter.athena.dataprocess.enums.DataType;
import com.ccb.testcenter.athena.dataprocess.enums.MapType;
import com.ccb.testcenter.athena.dataprocess.exception.ConvertException;
import com.ccb.testcenter.athena.dataprocess.util.ExcelHelper;

public class ServiceSegment {
	
	private Element rootElement;
	private List<Item> items = new ArrayList<Item>();
	
	public Element getRootElement() {
		return rootElement;
	}

	public void setRootElement(Element rootElement) {
		this.rootElement = rootElement;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public ServiceSegment(Element rootElement, Sheet sheet) throws Exception {
		this.rootElement = rootElement;
		
		int rowNum = sheet.getPhysicalNumberOfRows();

		Stack<String> groups = new Stack<String>();

		for (int i = 2; i < rowNum; i++) {
			Row row = sheet.getRow(i);

			String name = ExcelHelper.getCellValue(row.getCell(0));	//栏位项目名称
			int index = StringUtils.lastIndexOf(name, ".") + 1;
			if (index % 2 != 0)
				throw new RuntimeException("not valid");

			String nameZh = ExcelHelper.getCellValue(row.getCell(1));	//中文名称
			String identifier = ExcelHelper.getCellValue(row.getCell(2));	//数据项编号
			String length = ExcelHelper.getCellValue(row.getCell(3));	//XML输入长度
			DataType dataType = DataType.valueOf(ExcelHelper.getCellValue(row.getCell(5)));	//栏位属性
			boolean required = "Y".equals(ExcelHelper.getCellValue(row.getCell(7))) ? true : false;	//必须
			String note = ExcelHelper.getCellValue(row.getCell(9));	//数据项编号
			String encoding = ExcelHelper.getCellValue(row.getCell(10));	//码制
			String secure = ExcelHelper.getCellValue(row.getCell(11));

			int level = index / 2;
			int size = groups.size();
			if (level > 0) {
				if (level > size)
					throw new RuntimeException("not valid");

				for (int j = level; j < size; j++)
					groups.pop();
			}

			String tagName = name.substring(index); // xml节点名称
			StringBuilder suffix = new StringBuilder();
			for (String tag : groups) {
				suffix.append(tag).append(".");
			}
			String fullName = suffix.toString() + tagName;
			
			TransitionRule transitionRule = null;

			if (DataType.GROUP.equals(dataType)) {
				length = StringUtils.substringAfter(length, "*");
				groups.push(tagName);
			}else {		
				MapType mapType = MapType.valueOf(ExcelHelper.getCellValue(row.getCell(12)));
				String parameter = ExcelHelper.getCellValue(row.getCell(13));
//				Convertible converter = null;
				switch (mapType) {
				case a:
					Rule directRule = ContextHelper.getCtx().getBean(AthenaConstants.DIRECT_RULE, Rule.class);
//					converter = new DirectConverter();
					transitionRule = new TransitionRule(mapType, directRule, parameter);
					break;
				case b:
					Rule constantRule = ContextHelper.getCtx().getBean(AthenaConstants.CONSTANT_RULE, Rule.class);
//					converter = new ConstantConverter();
					transitionRule = new TransitionRule(mapType, constantRule, parameter);
					break;
				case c:
					break;
				case d:
					String ruleName = StringUtils.substringBefore(parameter, " ");
					String value = StringUtils.substringAfter(parameter, " ");
					String[] values = value.split(",");
	
					Rule rule = ContextHelper.getCtx().getBean(ruleName, Rule.class);
					String[] params = rule.getParams();
	
					if (values.length > params.length)
						throw new RuntimeException("not valid");
	
					String[] realParams = new String[params.length];
					int m = 0;
					while (m < values.length) {
						realParams[m] = StringUtils.isBlank(values[m]) ? params[m] : values[0];
						m++;
					}
					while (m < params.length) {
						realParams[m] = params[m];
						m++;
					}
	
					transitionRule = new TransitionRule(mapType, rule, realParams);
				}
			}
			
			Field field = new Field();
			field.setNameZh(nameZh);
			field.setIdentifier(identifier);
			field.setLength(length);
			field.setDataType(dataType);
			field.setRequired(required);
			field.setNote(note);
			field.setTagName(tagName);
			field.setFullName(fullName);
			field.setLevel(level);
			field.setEncoding(encoding);
			field.setSecure(secure);

			Item item = new Item(field, transitionRule);
			
			items.add(item);
		}
	}

	public void addElements(Map<String, String> data) {
		Stack<Group> groups = new Stack<Group>();
		
		Element currentElement = rootElement;	
		for(int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			
			Field field = item.getField();
			TransitionRule transitionRule = item.getTransitionRule();
			
			String tagName = field.getTagName();	//xml节点名称
			
			int level = field.getLevel();
			if(level > 0) {
				int size = groups.size();
				if(level < size) {		//表示有group结束
					for(int j = level; j < size; j++) {
						Group group = groups.peek();
						if(group.isEnd()) {
							groups.pop();
							currentElement = currentElement.getParent();
						}else {
							group.increase();
							i = group.getStart();
							
							break;
						}
					}
					continue;
				}
			}
			
			if(field.isGroup()) {
				int loop = Integer.parseInt(field.getLength());
								
				Group group = new Group(tagName, loop, 1, i);
				groups.push(group);
				
				currentElement = currentElement.addElement(tagName);
				
				continue;
			}
									
			Element element = currentElement.addElement(tagName);
			if(transitionRule != null) {
				MapType mapType = transitionRule.getMapType();
				String[] params = transitionRule.getParams();				
				String[] values = new String[params.length];
				System.arraycopy(params, 0, values, 0, params.length);
				
				if(mapType.equals(MapType.a) || mapType.equals(MapType.d) ) {
					//获取下标
					StringBuilder subscript = new StringBuilder();
					if(groups.size() > 0) {
						StringBuilder sb = new StringBuilder();
						for(Group group : groups) {
							if(group.getTimes() > 1) {
								sb.append(group.getCurrent()).append(",");
							}
						}
						if(sb.length() > 0) {
							subscript.append("(").append(sb.deleteCharAt(sb.length()-1)).append(")");
						}
					}
					if(subscript.length() > 0) {
						for(int j = 0; j < values.length; j++) {
							if(values[j].endsWith("*")) {
								values[j] = values[j].replace("*", subscript.toString());
							}
						}			
					}
				}
				
				try {
//					String text = transitionRule.convert(data, values);
					element.addCDATA(transitionRule.convert(data, values));				
				}catch(ConvertException e) {
				}
			}
		}
	}
	
}
