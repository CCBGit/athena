package com.ccb.testcenter.athena.dataprocess.entity;

import java.util.Map;

import com.ccb.testcenter.athena.dataprocess.convert.Convertible;
import com.ccb.testcenter.athena.dataprocess.exception.ConvertException;

public class Rule {

	private String name;
	private Convertible converter;
	private String[] params;

	public Rule() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Convertible getConverter() {
		return converter;
	}

	public void setConverter(Convertible converter) {
		this.converter = converter;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}

	public String doConvert(Map<String, String> data, String...params) throws ConvertException {
		// TODO Auto-generated method stub
		return converter.convert(data, params);
	}
}
