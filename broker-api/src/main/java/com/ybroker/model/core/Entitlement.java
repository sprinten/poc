package com.ybroker.model.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.enunciate.doc.DocumentationExample;
import org.codehaus.enunciate.doc.ExampleType;

import com.ybroker.model.core.base.Resource;

/**
 * Entitlement representation.
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlRootElement(name = "Entitlement")
public class Entitlement extends Resource {

	private Operation operation;
	private Role role;
	private String displayName;

	/**
	 * A human readable name for the entitlement.
	 * 
	 * @return possible object is {@link String }
	 */
	@XmlElement(required = true)
	@DocumentationExample(validTypes = ExampleType.JSON, value = "ReadWriteOnConcole")
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String value) {
		this.displayName = value;
	}

	@XmlElement(required = true)
	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	@XmlElement(required = true)
	public Role getRole() {
		return role;
	}

	public void setRole(Role group) {
		this.role = group;
	}

}
