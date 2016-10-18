package com.ccb.testcenter.athena.dataprocess.entity.service;

/**
 * 
 * @author pandong
 *
 * 服务接口
 */
public class Service {

	private String serviceId;
	private String serviceName;
	
	private String[] requestComs;
	private String[] responseComs;
	
	private XML requestXML;
	private XML responseXML;

	public Service(String serviceId, String serviceName, String[] requestComs, String[] responseComs) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.requestComs = requestComs;
		this.responseComs = responseComs;
		
		requestXML = new RequestXML(requestComs);
		responseXML = new ResponseXML(responseComs);
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String[] getRequestComs() {
		return requestComs;
	}

	public void setRequestComs(String[] requestComs) {
		this.requestComs = requestComs;
	}

	public String[] getResponseComs() {
		return responseComs;
	}

	public void setResponseComs(String[] responseComs) {
		this.responseComs = responseComs;
	}

	public XML getRequestXML() {
		return requestXML;
	}

	public XML getResponseXML() {
		return responseXML;
	}
	
}
