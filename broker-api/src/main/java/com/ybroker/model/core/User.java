package com.ybroker.model.core;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.enunciate.doc.DocumentationExample;
import org.codehaus.enunciate.doc.ExampleType;

import com.google.gson.Gson;
import com.ybroker.model.core.base.MultiValuedAttribute;
import com.ybroker.model.core.contact.Contact;

/**
 * User representation.
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(name = "User", propOrder = { "schemas", "id", "externalId",
		"userName", "name", "displayName", "userType", "nickName", "profileUrl", "title",
		"userType", "preferredLanguage", "locale", "timezone", "active",
		"password", "emails", "phoneNumbers", "ims", "photos", "addresses",
		"groups", "entitlements", "roles", "x509Certificates"})
@XmlRootElement(name = "User")
public class User extends Contact {

	public static enum Type {
		Internal, Customer, Provider, Reseller
	}

	private String userName;
	private String profileUrl;
	private Type userType;
	private String preferredLanguage;
	private String locale;
	private String timezone;
	private Boolean active;
	private String password;

	private List<Entitlement> entitlements;
	private List<Role> roles;
	private List<MultiValuedAttribute> x509Certificates;


	/**
	 * Unique identifier for the User, typically used by the user to directly
	 * authenticate to the service provider. Often displayed to the user as
	 * their unique identifier within the system (as opposed to id or
	 * externalId, which are generally opaque and not user-friendly
	 * identifiers). Each User MUST include a non-empty userName value. This
	 * identifier MUST be unique across the Service Consumer's entire set of
	 * Users. REQUIRED.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@XmlElement(required = true)
	@DocumentationExample(validTypes = ExampleType.JSON, value = "john.doe")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String value) {
		this.userName = value;
	}

	/**
	 * A fully qualified URL to a page representing the User's online profile.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@DocumentationExample(validTypes = ExampleType.JSON, value = "http://facebook/john.doe")
	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String value) {
		this.profileUrl = value;
	}

	/**
	 * Used to identify the organization to user relationship. Typical values
	 * used might be "Contractor", "Employee", "Intern", "Temp", "External", and
	 * "Unknown" but any value may be used.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@DocumentationExample(validTypes = ExampleType.JSON, value = "Employee")
	public Type getUserType() {
		return userType;
	}

	public void setUserType(Type value) {
		this.userType = value;
	}

	/**
	 * Indicates the User's preferred written or spoken language. Generally used
	 * for selecting a localized User interface. Valid values are concatenation
	 * of the ISO 639-1 two letter language code, an underscore, and the ISO
	 * 3166-1 2 letter country code.
	 * 
	 * @return possible object is {@link String }
	 */
	@DocumentationExample(validTypes = ExampleType.JSON, value = "en_US")
	public String getPreferredLanguage() {
		return preferredLanguage;
	}

	public void setPreferredLanguage(String value) {
		this.preferredLanguage = value;
	}

	/**
	 * Used to indicate the User's default location for purposes of localizing
	 * items such as currency, date time format, numerical representations, etc.
	 * A locale value is a concatenation of the ISO 639-1 two letter language
	 * code, an underscore, and the ISO 3166-1 2 letter country code.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@DocumentationExample(validTypes = ExampleType.JSON, value = "en_US")
	public String getLocale() {
		return locale;
	}

	public void setLocale(String value) {
		this.locale = value;
	}

	/**
	 * The User's time zone in the "Olson" timezone database format.
	 * 
	 * @return possible object is {@link String }
	 */
	@DocumentationExample(validTypes = ExampleType.JSON, value = "America/Los_Angeles")
	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String value) {
		this.timezone = value;
	}

	/**
	 * A Boolean value indicating the User's administrative status. The
	 * definitive meaning of this attribute is determined by the Service
	 * Provider though a value of true infers the User is, for example, able to
	 * login while a value of false implies the User's account has been
	 * suspended.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean value) {
		this.active = value;
	}

	/**
	 * The User's clear text password. This attribute is intended to be used as
	 * a means to specify an initial password when creating a new User or to
	 * reset an existing User's password. No accepted standards exist to convey
	 * password policies, hence Consumers should expect Service Providers to
	 * reject password values. This value MUST never be returned by a Service
	 * Provider in any form.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPassword() {
		return password;
	}

	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * A list of entitlements for the User that represent a thing the User has.
	 * That is, an entitlement is an additional right to a thing, object or
	 * service. No vocabulary or syntax is specified and Service
	 * Providers/Consumers are expected to encode sufficient information in the
	 * value so as to accurately and without ambiguity determine what the User
	 * has access to. This value has NO canonical types though type may be
	 * useful as a means to scope entitlements.
	 * 
	 * @return possible object is {@link List<MultiValuedAttribute> }
	 */
	public List<Entitlement> getEntitlements() {
		return entitlements;
	}

	public void setEntitlements(List<Entitlement> value) {
		this.entitlements = value;
	}

	/**
	 * A list of roles for the User that collectively represent who the User is;
	 * e.g., 'Student', "Faculty". No vocabulary or syntax is specified though
	 * it is expected that a role value is a String or label representing a
	 * collection of entitlements. This value has NO canonical types.
	 * 
	 * @return possible object is {@link List<MultiValuedAttribute> }
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param value
	 *            allowed object is {@link List<MultiValuedAttribute> }
	 */
	public void setRoles(List<Role> value) {
		this.roles = value;
	}

	/**
	 * A list of certificates issued to the User. Values are Binary and DER
	 * encoded x509. This value has NO canonical types.
	 * 
	 * @return possible object is {@link List<MultiValuedAttribute> }
	 */
	public List<MultiValuedAttribute> getX509Certificates() {
		return x509Certificates;
	}

	/**
	 * @param value
	 *            allowed object is {@link List<MultiValuedAttribute> }
	 */
	public void setX509Certificates(List<MultiValuedAttribute> value) {
		this.x509Certificates = value;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
