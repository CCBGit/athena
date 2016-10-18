package com.ccb.testcenter.athena.dataprocess.convert;

import java.util.HashMap;
import java.util.Map;

public class KVConverter implements Convertible {
	
	private String defaultValue;
	private Map<String, String> keyValues = new HashMap<String, String>();

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public Map<String, String> getKeyValues() {
		return keyValues;
	}

	public void setKeyValues(Map<String, String> keyValues) {
		this.keyValues = keyValues;
	}

	@Override
	public String convert(Map<String, String> data, String...params) {
		// TODO Auto-generated method stub
		String value = data.get(params[0]);
		
		if(keyValues.containsKey(value)) {
			return keyValues.get(value);
		}else {
			if(defaultValue != null)
				return defaultValue;
			else 
				throw new RuntimeException();
		}
	}
}
