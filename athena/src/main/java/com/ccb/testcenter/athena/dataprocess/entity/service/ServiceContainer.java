package com.ccb.testcenter.athena.dataprocess.entity.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.ccb.testcenter.athena.dataprocess.mapping.Constant;
import com.ccb.testcenter.athena.dataprocess.mapping.ServiceMapping;
import com.ccb.testcenter.athena.dataprocess.util.ExcelHelper;

public class ServiceContainer {
	private static Map<String, Service> serviceMap = new HashMap<String, Service>();
	private static Map<String, ServiceMapping> serviceMappingMap = new HashMap<String, ServiceMapping>();
	private ServiceContainer() {
		
	}
	
	static {
		try {
			Workbook workbook  = WorkbookFactory.create(ServiceContainer.class.getResourceAsStream(Constant.SERVICE_PATH));
			
			Sheet serviceSheet = workbook.getSheet("服务列表");			
			for(int i = 1; i < serviceSheet.getPhysicalNumberOfRows(); i++) {
				String serviceId = ExcelHelper.getCellValue(serviceSheet.getRow(i).getCell(0));
				String serviceName = ExcelHelper.getCellValue(serviceSheet.getRow(i).getCell(1));
				String requestCom= ExcelHelper.getCellValue(serviceSheet.getRow(i).getCell(4));
				String[] requestComs = requestCom.split(";");
				String responseCom = ExcelHelper.getCellValue(serviceSheet.getRow(i).getCell(5));
				String[] responseComs = responseCom.split(";");
				Service service = new Service(serviceId, serviceName, requestComs, responseComs);
				
				serviceMap.put(serviceId, service);
			}
			
			Sheet mappingSheet = workbook.getSheet("映射列表");
			for(int i = 1; i < mappingSheet.getPhysicalNumberOfRows(); i++) {
				String mapName = ExcelHelper.getCellValue(mappingSheet.getRow(i).getCell(0));
				String serviceId = ExcelHelper.getCellValue(mappingSheet.getRow(i).getCell(1));
				boolean mapRequest = Boolean.parseBoolean(ExcelHelper.getCellValue(mappingSheet.getRow(i).getCell(2)));
				boolean mapResponse = Boolean.parseBoolean(ExcelHelper.getCellValue(mappingSheet.getRow(i).getCell(3)));
				
				
				try {
					ServiceMapping serviceMapping  = new ServiceMapping(mapName, serviceId, mapRequest, mapResponse);
					serviceMappingMap.put(mapName, serviceMapping);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Service getService(String serviceId) {
		return serviceMap.get(serviceId);
	}
	
	public static ServiceMapping getServiceMapping(String mapName) {
		return serviceMappingMap.get(mapName);
	}
}
