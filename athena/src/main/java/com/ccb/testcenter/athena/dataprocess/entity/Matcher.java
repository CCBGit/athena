package com.ccb.testcenter.athena.dataprocess.entity;

import java.util.HashMap;
import java.util.Map;

public class Matcher {
	
	private Map<String, String> map = new HashMap<String, String>();
	private String key = "INT-TX-ID";
	
	public Matcher() {
		map.put("SA0213800", "A0182S303");
		map.put("SA0106103", "A0182S501");
	}
	
	public String match(Map<String, String> data) {
		String srcId = data.get(key);
		
		return map.get(srcId);
	}
}
