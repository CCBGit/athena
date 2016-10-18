package com.ccb.testcenter.athena.dataprocess.mapping;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.ccb.testcenter.athena.dataprocess.entity.service.Service;

/**
 * 
 * @author pandong
 *
 * 服务响应映射
 */
public class ServiceResponse extends ServiceSegments {

	public ServiceResponse(Service service, Sheet sheet) throws Exception {
		xml = service.getResponseXML();
		String[] coms = service.getResponseComs();
		
		Workbook workbook = WorkbookFactory.create(this.getClass().getResourceAsStream(Constant.COMMON_MAPPING_PATH + "common.xlsx"));
		Sheet header = workbook.getSheet("RES_TX_HEADER");
		TX_HEADER = new ServiceSegment(xml.getTX_HEADER(), header);	
		
		COMS = new ServiceSegment[coms.length];
		for(int i = 0; i < coms.length; i++) {
			Sheet com = workbook.getSheet(coms[i]);
			COMS[i] = new ServiceSegment(xml.getCOM(coms[i]), com);
		}
		
		ENTITY = new ServiceSegment(xml.getENTITY(), sheet);	
	}
	
}
