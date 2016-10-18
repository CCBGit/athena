package com.ccb.testcenter.athena.dataprocess.mapping;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Constant {
	public static String DIRECT = "DIRECT_CONVERTER";
	public static String CONSTANT = "CONSTANT_CONVERTER";
	
	public static String COMMON_MAPPING_PATH = "/conf/mapping/common/";
	public static String ENTITY_MAPPING_PATH = "/conf/mapping/entity/";
	public static String SERVICE_PATH = "/conf/service/service.xlsx";
	
	static {
		try {
			Workbook workbook = WorkbookFactory.create(Constant.class.getResourceAsStream(Constant.COMMON_MAPPING_PATH + "common.xlsx"));
//			Sheet REQ_TX_HEADER = workbook.getSheet("REQ_TX_HEADER");
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
}
