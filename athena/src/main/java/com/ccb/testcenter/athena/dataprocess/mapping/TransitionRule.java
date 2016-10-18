package com.ccb.testcenter.athena.dataprocess.mapping;

import java.util.Map;

import com.ccb.testcenter.athena.dataprocess.convert.Convertible;
import com.ccb.testcenter.athena.dataprocess.entity.Rule;
import com.ccb.testcenter.athena.dataprocess.enums.MapType;
import com.ccb.testcenter.athena.dataprocess.exception.ConvertException;

/**
 * 
 * @author pandong
 *
 * 映射规则
 */
public class TransitionRule {
	
	private MapType mapType;
	private Rule rule;
	private String[] params;

	public MapType getMapType() {
		return mapType;
	}

	public void setMapType(MapType mapType) {
		this.mapType = mapType;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}

	public TransitionRule(MapType mapType, Rule rule, String...params) {
		super();
		this.mapType = mapType;
		this.rule = rule;
		this.params = params;
	}
	
	public String convert(Map<String, String> data, String...params) throws ConvertException {
		return rule.doConvert(data, params);
	}

}
