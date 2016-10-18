package com.ccb.testcenter.athena.dataprocess.entity.service;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class RequestXML extends BaseXML {
	
	private Element COM1;
	private Element COM2;
	private Element COM3;
	private Element COM4;
	private Element COM5;
	private Element COM6;
	private Element COM7;
	
	public RequestXML(String[] coms) {
		super();
		COM1 = DocumentHelper.createElement("COM1");
		COM2 = DocumentHelper.createElement("COM2");
		COM3 = DocumentHelper.createElement("COM3");
		COM4 = DocumentHelper.createElement("COM4");
		COM5 = DocumentHelper.createElement("COM5");
		COM6 = DocumentHelper.createElement("COM6");
		COM7 = DocumentHelper.createElement("COM7");
		
		COMS.put("COM1", COM1);
		COMS.put("COM2", COM2);
		COMS.put("COM3", COM3);
		COMS.put("COM4", COM4);
		COMS.put("COM5", COM5);
		COMS.put("COM6", COM6);
		COMS.put("COM7", COM7);
		
		for(String com : coms) {
			Element element = COMS.get(com);
			COMMON.add(element);
		}
	}

}
