package com.ybroker.model.core.contact;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.enunciate.doc.DocumentationExample;
import org.codehaus.enunciate.doc.ExampleType;

import com.google.gson.Gson;

@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(name = "name", propOrder = { "formatted", "familyName", "givenName", "middleName", "honorificPrefix",
		"honorificSuffix" })
public class Name {

	private String formatted;
	private String familyName;
	private String givenName;
	private String middleName;
	private String honorificPrefix;
	private String honorificSuffix;

	/**
	 * The full name, including all middle names, titles, and suffixes as
	 * appropriate, formatted for display
	 * 
	 * @return possible object is {@link String }
	 */
	@DocumentationExample(validTypes = ExampleType.JSON, value = "Mr. John Patrick Doe, III.")
	public String getFormatted() {
		return formatted;
	}

	public void setFormatted(String value) {
		this.formatted = value;
	}

	/**
	 * The family name of the User, or "Last Name" in most Western languages
	 * 
	 * @return possible object is {@link String }
	 */
	@DocumentationExample(validTypes = ExampleType.JSON, value = "Doe")
	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String value) {
		this.familyName = value;
	}

	/**
	 * The given name of the User, or "First Name" in most Western languages
	 * 
	 * @return possible object is {@link String }
	 */
	@DocumentationExample(validTypes = ExampleType.JSON, value = "John")
	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String value) {
		this.givenName = value;
	}

	/**
	 * The middle name(s) of the User.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@DocumentationExample(validTypes = ExampleType.JSON, value = "Patrick")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String value) {
		this.middleName = value;
	}

	/**
	 * The honorific prefix(es) of the User, or "Title" in most Western
	 * languages
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@DocumentationExample(validTypes = ExampleType.JSON, value = "Mr.")
	public String getHonorificPrefix() {
		return honorificPrefix;
	}

	public void setHonorificPrefix(String value) {
		this.honorificPrefix = value;
	}

	/**
	 * The honorific suffix(es) of the User, or "Suffix" in most Western
	 * languages
	 * 
	 * @return possible object is {@link String }
	 */
	@DocumentationExample(validTypes = ExampleType.JSON, value = "III.")
	public String getHonorificSuffix() {
		return honorificSuffix;
	}

	public void setHonorificSuffix(String value) {
		this.honorificSuffix = value;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
	
}