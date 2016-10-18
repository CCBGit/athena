package com.ccb.testcenter.athena.dataprocess.mapping;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextHelper {
	private static ApplicationContext ctx;
	private ContextHelper() {
		
	}
	
	static {
		ctx = new ClassPathXmlApplicationContext(new String[]{"converter.xml", "rule.xml"});
//		, "mapping.xml"
//		ServiceMapping serviceMapping = ctx.getBean("SA0213800-A0182S303", ServiceMapping.class);
	}
	
	public static ApplicationContext getCtx() {
		return ctx;
	}
}
