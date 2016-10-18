package com.ccb.testcenter.athena.dataprocess.entity.service;

import org.dom4j.Element;

public interface XML {
	public Element getTX_HEADER();
	public Element getCOM(String com);
	public Element getENTITY();
	
	public String getContent();
	public String getContent(boolean formatted);
}
