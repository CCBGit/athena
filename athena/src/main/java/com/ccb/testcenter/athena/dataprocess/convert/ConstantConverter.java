package com.ccb.testcenter.athena.dataprocess.convert;

import java.util.Map;

public class ConstantConverter implements Convertible {

	public String convert(Map<String, String> data, String...params) {
		// TODO Auto-generated method stub
		return params[0];
	}
	
}
