package com.ccb.testcenter.athena.dataprocess.entity.service;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class ResponseXML extends BaseXML {
	
	private Element COMA;
	private Element COMB;
	
	public ResponseXML(String[] coms) {
		super();
		COMA = DocumentHelper.createElement("COMA");
		COMB = DocumentHelper.createElement("COMB");
		
		COMS.put("COMA", COMA);
		COMS.put("COMB", COMB);
		
		for(String com : coms) {
			Element element = COMS.get(com);
			COMMON.add(element);
		}
	}
}
