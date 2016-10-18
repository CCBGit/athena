package com.ccb.testcenter.athena.dataprocess.convert;

import java.util.Map;

import com.ccb.testcenter.athena.dataprocess.exception.ConvertException;

/**
 * 
 * @author pandong
 * 
 */
public interface Convertible {
	
	String convert(Map<String, String> data, String...params) throws ConvertException;

}
