package com.ymens.broker.api.model.scim.internal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.Gson;

/**
 * A Resource attribute that contains 0..n values; e.g., emails.Multi-valued
 * attributes are unordered lists of attributes. Each attribute MAY contain
 * Sub-Attributes and therefore multi-valued attributes may contain Complex
 * Attributes.
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(name = "MultiValuedAttribute", propOrder = { "value", "display", "primary", "type", "operation" })
public class MultiValuedAttribute {

	private Object value;
	private String display;
	private Boolean primary;
	private String type;
	private String operation;

	/**
	 * The attribute's significant value; e.g., the e-mail address, phone
	 * number, etc. Attributes that define a "value" sub-attribute MAY be
	 * alternately represented as a collection of primitive types.
	 * 
	 * @return possible object is {@link Object }
	 * 
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value
	 *            allowed object is {@link Object }
	 * 
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * A human readable name, primarily used for display purposes. READ-ONLY.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDisplay() {
		return display;
	}

	/**
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDisplay(String value) {
		this.display = value;
	}

	/**
	 * A Boolean value indicating the 'primary' or preferred attribute value for
	 * this attribute, e.g. the preferred mailing address or primary e-mail
	 * address. The primary attribute value 'true' MUST appear no more than
	 * once.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean getPrimary() {
		return primary;
	}

	/**
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setPrimary(Boolean value) {
		this.primary = value;
	}

	/**
	 * A label indicating the attribute's function; e.g., "work" or "home".
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setType(String value) {
		this.type = value;
	}

	/**
	 * The operation to perform on the multi-valued attribute during a PATCH
	 * request. The only valid value is "delete", which signifies that this
	 * instance should be removed from the Resource.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOperation(String value) {
		this.operation = value;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
