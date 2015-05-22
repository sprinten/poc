package com.ybroker.model.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Allowed operations (mapped to HTTP verbs)
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlRootElement(name = "Operation")
public enum Operation {
	GET, POST, PUT, DELETE, PATCH, HEAD, OPTIONS
}
