package com.ybroker.model.core.contact;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.Gson;
import com.ybroker.model.core.base.MultiValuedAttribute;

/**
 * Representation of the contact address.
 */

/**
 * A physical mailing address for this User. Canonical Type Values of work,
 * home, and other. The value attribute is a complex type with the following
 * sub-attributes. All Sub-Attributes are OPTIONAL.
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(name = "address", propOrder = { "formatted", "streetAddress",
		"locality", "region", "postalCode", "country" })
public class Address extends MultiValuedAttribute {

	private String formatted;
	private String streetAddress;
	private String locality;
	private String region;
	private String postalCode;
	private String country;

	/**
	 * The full mailing address, formatted for display or use with a mailing
	 * label. This attribute MAY contain newlines.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFormatted() {
		return formatted;
	}

	/**
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFormatted(String value) {
		this.formatted = value;
	}

	/**
	 * The full street address component, which may include house number, street
	 * name, P.O. box, and multi-line extended street address information. This
	 * attribute MAY contain newlines.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setStreetAddress(String value) {
		this.streetAddress = value;
	}

	/**
	 * The city or locality component.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLocality() {
		return locality;
	}

	/**
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLocality(String value) {
		this.locality = value;
	}

	/**
	 * The state or region component.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRegion(String value) {
		this.region = value;
	}

	/**
	 * The zipcode or postal code component.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPostalCode(String value) {
		this.postalCode = value;
	}

	/**
	 * The country name component. When specified the value MUST be in ISO
	 * 3166-1 alpha 2 "short" code format; e.g., the United States and Sweden
	 * are "US" and "SE", respectively.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the value of the country property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCountry(String value) {
		this.country = value;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
