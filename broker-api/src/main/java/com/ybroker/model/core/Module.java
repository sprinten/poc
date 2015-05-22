package com.ybroker.model.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Module representation.
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlRootElement(name = "Module")
public class Module extends Service {

	public enum Type {
		Internal, Provider, Reseller, Customer
	}

	private Type moduleType;

	public Type getModuleType() {
		return moduleType;
	}

	public void setModuleType(Type moduleType) {
		this.moduleType = moduleType;
	}

}
