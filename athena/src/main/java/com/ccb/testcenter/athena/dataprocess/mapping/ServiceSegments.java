package com.ccb.testcenter.athena.dataprocess.mapping;

import java.util.Map;

import com.ccb.testcenter.athena.dataprocess.entity.service.XML;

/**
 * 
 * @author pandong
 *
 * 服务映射
 */
public abstract class ServiceSegments {

	protected ServiceSegment TX_HEADER;
	protected ServiceSegment[] COMS;
	protected ServiceSegment ENTITY;

	protected XML xml;
	
	public String getXML(Map<String, String> data) {
		TX_HEADER.addElements(data);
		for(ServiceSegment com : COMS) {
			com.addElements(data);
		}
		ENTITY.addElements(data);
		
		return xml.getContent();
	}
	
}
