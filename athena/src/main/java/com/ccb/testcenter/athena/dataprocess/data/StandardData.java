package com.ccb.testcenter.athena.dataprocess.data;

import java.util.HashMap;
import java.util.Map;

public class StandardData {

	private String convertId;
	private Map<String, String> data = new HashMap<String, String>();

	public String getConvertId() {
		return convertId;
	}

	public void setConvertId(String convertId) {
		this.convertId = convertId;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

}
