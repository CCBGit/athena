package com.ccb.testcenter.athena.dataprocess.convert;

import java.util.Map;

import com.ccb.testcenter.athena.dataprocess.exception.ConvertException;
import com.ccb.testcenter.athena.dataprocess.exception.KeyNotFoundException;

public class DirectConverter implements Convertible {

	public String convert(Map<String, String> data, String... params) throws ConvertException {
		// TODO Auto-generated method stub
		String value = data.get(params[0]);
		if(value == null) {
			throw new KeyNotFoundException();
		}
		
		return value;
	}

}
