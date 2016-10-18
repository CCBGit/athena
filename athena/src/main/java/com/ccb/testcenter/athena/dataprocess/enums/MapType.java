package com.ccb.testcenter.athena.dataprocess.enums;

public enum MapType {
	a("DIRECT"), b("CONSTANT"), c("NULL"), d("TRANSITION");
	
	private String label;
	
	private MapType(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
}
