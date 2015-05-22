package com.ybroker.model.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Application representation.
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlRootElement(name = "Application")
public class Application extends Service {

	public enum Type {
		SaaS, PaaS, IaaS, Virtual, Hosted
	}

	private Unit provider;
	private Type applicationType;

	public Type getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(Type applicationType) {
		this.applicationType = applicationType;
	}

	public Unit getProvider() {
		return provider;
	}

	public void setProvider(Unit provider) {
		this.provider = provider;
	}
}
