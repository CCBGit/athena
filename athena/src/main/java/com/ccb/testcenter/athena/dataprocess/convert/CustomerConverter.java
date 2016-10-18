package com.ccb.testcenter.athena.dataprocess.convert;

public class CustomerConverter {
	
	protected String name;
	protected String[] params;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String...params) {
		this.params = params;
	}
		
}
