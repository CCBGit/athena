package com.ccb.testcenter.athena.dataprocess.mapping;

import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.ccb.testcenter.athena.dataprocess.entity.service.Service;
import com.ccb.testcenter.athena.dataprocess.entity.service.ServiceContainer;

/**
 * 
 * @author pandong
 * 
 * 服务映射
 */
public class ServiceMapping {
	
//	private String mapName;	
//	private Service service;	
//	
//	private boolean mapRequest = true;
//	private boolean mapResponse = false;
	
	private ServiceRequest request;
	private ServiceResponse response;
	
//	public String getMapName() {
//		return mapName;
//	}
//
//	public void setMapName(String mapName) {
//		this.mapName = mapName;
//	}

//	public Service getService() {
//		return service;
//	}
//
//	public void setService(Service service) {
//		this.service = service;
//	}
//
//	public ServiceRequest getRequest() {
//		return request;
//	}
//
//	public void setRequest(ServiceRequest request) {
//		this.request = request;
//	}
//
//	public ServiceResponse getResponse() {
//		return response;
//	}
//
//	public void setResponse(ServiceResponse response) {
//		this.response = response;
//	}

	public ServiceMapping(String mapName, String serviceId, boolean mapRequest, boolean mapResponse) throws Exception {
		Service service = ServiceContainer.getService(serviceId);
		
		Workbook workbook = WorkbookFactory.create(this.getClass().getResourceAsStream(Constant.ENTITY_MAPPING_PATH + mapName + ".xlsx"));
		if(mapRequest) {
			Sheet requestSheet = workbook.getSheet("request");
			if(requestSheet == null) {
				
			}
			request = new ServiceRequest(service, requestSheet);
		}

		if(mapResponse) {
			Sheet responseSheet = workbook.getSheet("response");
			if(responseSheet == null) {
				
			}
			response = new ServiceResponse(service, responseSheet);
		}
	}
	
	public String getRequestXML(Map<String, String> data) {
		return request.getXML(data);
	}
	
	public String getResponseXML(Map<String, String> data) {
		return response.getXML(data);
	}
	
//	public void load(String fileName) throws Exception {
//		Workbook workbook = WorkbookFactory.create(this.getClass().getResourceAsStream(Constant.ENTITY_MAPPING_PATH + fileName));
//		Sheet serviceSheet = workbook.getSheet(destServiceId);
//		
//		String serviceId = ExcelHelper.getCellValue(serviceSheet.getRow(0).getCell(1));
//		String serviceName = ExcelHelper.getCellValue(serviceSheet.getRow(1).getCell(1));
//		String requestCom= ExcelHelper.getCellValue(serviceSheet.getRow(4).getCell(1));
//		String[] requestComs = requestCom.split(";");
//		String responseCom = ExcelHelper.getCellValue(serviceSheet.getRow(5).getCell(1));
//		String[] responseComs = responseCom.split(";");
//		
//		service = new Service(serviceId, serviceName, requestComs, responseComs);
//		
//
//	}
	
}
