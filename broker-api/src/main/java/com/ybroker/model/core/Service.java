package com.ybroker.model.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Service representation.
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlRootElement(name = "Service")
public class Service extends Group {

	public enum Type {
		Generic, Application, Module
	}

	private String endpoint;
	private String parameneters;
	private Type serviceType;

	public Type getServiceType() {
		return serviceType;
	}

	public void setServiceType(Type serviceType) {
		this.serviceType = serviceType;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String url) {
		this.endpoint = url;
	}

	public String getParameneters() {
		return parameneters;
	}

	public void setParameneters(String parameneters) {
		this.parameneters = parameneters;
	}

}
