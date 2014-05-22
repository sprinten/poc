package com.ymens.broker.api.model.scim.internal;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * A complex attribute containing resource metadata. All sub-attributes are
 * OPTIONAL.
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(name = "Meta", propOrder = { "created", "lastModified", "location", "version", "attributes" })
public class Meta {

	
	private XMLGregorianCalendar created;
	private XMLGregorianCalendar lastModified;
	private String location;
	private String version;
	private List<MultiValuedAttribute> attributes;

	/**
	 * The DateTime the Resource was added to the Service Provider. The
	 * attribute MUST be a DateTime. READ-ONLY. 
	 * 
	 * @return
	 */
	@XmlElement(required = false)
	@XmlSchemaType(name = "dateTime")
	public XMLGregorianCalendar getCreated() {
		return created;
	}

	/**
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setCreated(XMLGregorianCalendar value) {
		this.created = value;
	}

	/**
	 * The most recent DateTime the details of this Resource were updated at the
	 * Service Provider. If this Resource has never been modified since its
	 * initial creation, the value MUST be the same as the value of created. The
	 * attribute MUST be a DateTime. READ-ONLY.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	@XmlSchemaType(name = "dateTime")
	@XmlElement(required = false)
	public XMLGregorianCalendar getLastModified() {
		return lastModified;
	}

	/**
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setLastModified(XMLGregorianCalendar value) {
		this.lastModified = value;
	}

	/**
	 * The URI of the Resource being returned. This value MUST be the same as
	 * the Location HTTP response header. READ-ONLY.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@XmlElement(required = false)
	public String getLocation() {
		return location;
	}

	/**
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLocation(String value) {
		this.location = value;
	}

	/**
	 * The version of the Resource being returned. This value must be the same
	 * as the ETag HTTP response header. READ-ONLY.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@XmlElement(required = false)
	public String getVersion() {
		return version;
	}

	/**
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */

	public void setVersion(String value) {
		this.version = value;
	}

	/**
	 * The names of the attributes to remove from the Resource during a PATCH
	 * operation.
	 * 
	 * @return
	 * 
	 */
	@XmlElement(required = false)
	public List<MultiValuedAttribute> getAttributes() {
		return attributes;
	}

	/**
	 * @param value
	 */
	public void setAttributes(List<MultiValuedAttribute> value) {
		this.attributes = value;
	}

}
