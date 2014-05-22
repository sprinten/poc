package com.ymens.broker.api.model.generic;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * The Representation of a generic message/event.
 */
@XmlType(name = "Message")
@XmlRootElement(name = "Message")
public class Message extends Resource {

	private String code;

	private String key;
	private List<String> parameters;

	/**
	 * The code.
	 * 
	 * @return The code
	 */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * The key.
	 * 
	 * @return The key
	 */
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * The parameters.
	 * 
	 * @return The parameters
	 */
	public List<String> getParameters() {
		return parameters;
	}

	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}
}
