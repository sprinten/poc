package com.ymens.broker.api.model.scim;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.enunciate.doc.DocumentationExample;
import org.codehaus.enunciate.doc.ExampleType;

import com.google.gson.Gson;
import com.ymens.broker.api.model.generic.CoreResource;
import com.ymens.broker.api.model.scim.internal.MultiValuedAttribute;

/**
 * User representation.
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(name = "User", propOrder = { "schemas", "id", "externalId", "userName", "name", "displayName", "nickName",
		"profileUrl", "title", "userType", "preferredLanguage", "locale", "timezone", "active", "password", "emails",
		"phoneNumbers", "ims", "photos", "addresses", "groups", "entitlements", "roles", "x509Certificates", "meta" })
@XmlRootElement(name = "User")
public class User extends CoreResource {

	private String userName;
	private Name name;
	private String displayName;
	private String nickName;
	private String profileUrl;
	private String title;
	private String userType;
	private String preferredLanguage;
	private String locale;
	private String timezone;
	private Boolean active;
	private String password;

	private List<Address> addresses;

	private List<MultiValuedAttribute> emails;
	private List<MultiValuedAttribute> phoneNumbers;
	private List<MultiValuedAttribute> ims;
	private List<MultiValuedAttribute> photos;
	private List<MultiValuedAttribute> groups;
	private List<MultiValuedAttribute> entitlements;
	private List<MultiValuedAttribute> roles;
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
	 * The components of the User's real name. Providers MAY return just the
	 * full name as a single string in the formatted sub-attribute, or they MAY
	 * return just the individual component attributes using the other
	 * sub-attributes, or they MAY return both. If both variants are returned,
	 * they SHOULD be describing the same name, with the formatted name
	 * indicating how the component attributes should be combined.
	 * 
	 * @return possible object is {@link Name }
	 * 
	 */
	@DocumentationExample(validTypes = ExampleType.JSON, value = "John Doe")
	public Name getName() {
		return name;
	}

	public void setName(Name value) {
		this.name = value;
	}

	/**
	 * The name of the User, suitable for display to end-users. Each User
	 * returned MAY include a non-empty displayName value. The name SHOULD be
	 * the full name of the User being described if known (e.g. Babs Jensen or
	 * Ms. Barbara J Jensen, III), but MAY be a username or handle, if that is
	 * all that is available (e.g. bjensen). The value provided SHOULD be the
	 * primary textual label by which this User is normally displayed by the
	 * Service Provider when presenting it to end-users.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@DocumentationExample(validTypes = ExampleType.JSON, value = "Mr. John Doe")
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String value) {
		this.displayName = value;
	}

	/**
	 * The casual way to address the user in real life, e.g. "Bob" or "Bobby"
	 * instead of "Robert". This attribute SHOULD NOT be used to represent a
	 * User's username (e.g. bjensen or mpepperidge).
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@DocumentationExample(validTypes = ExampleType.JSON, value = "Johnny")
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String value) {
		this.nickName = value;
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
	 * The user’s title.
	 * 
	 * @return possible object is {@link String }
	 */
	@DocumentationExample(validTypes = ExampleType.JSON, value = "VP of Product")
	public String getTitle() {
		return title;
	}

	public void setTitle(String value) {
		this.title = value;
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
	public String getUserType() {
		return userType;
	}

	public void setUserType(String value) {
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
	 * E-mail addresses for the User. The value SHOULD be canonicalized by the
	 * Service Provider. Canonical Type values of work, home, and other.
	 * 
	 * @return possible object is {@link List<MultiValuedAttribute> }
	 * 
	 */
	public List<MultiValuedAttribute> getEmails() {
		return emails;
	}

	public void setEmails(List<MultiValuedAttribute> value) {
		this.emails = value;
	}

	/**
	 * Phone numbers for the User. The value SHOULD be canonicalized by the
	 * Service Provider according to format in RFC3966. Canonical Type values of
	 * work, home, mobile, fax, pager and other.
	 * 
	 * @return possible object is {@link List<MultiValuedAttribute> }
	 */
	public List<MultiValuedAttribute> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<MultiValuedAttribute> value) {
		this.phoneNumbers = value;
	}

	/**
	 * Instant messaging address for the User. No official canonicalization
	 * rules exist for all instant messaging addresses, but Service Providers
	 * SHOULD, when appropriate, remove all whitespace and convert the address
	 * to lowercase. Instead of the standard Canonical Values for type, this
	 * attribute defines the following Canonical Values to represent currently
	 * popular IM services: aim, gtalk, icq, xmpp, msn, skype, qq, and yahoo.
	 * 
	 * @return possible object is {@link List<MultiValuedAttribute> }
	 * 
	 */
	public List<MultiValuedAttribute> getIms() {
		return ims;
	}

	public void setIms(List<MultiValuedAttribute> value) {
		this.ims = value;
	}

	/**
	 * URL of a photo of the User. The value SHOULD be a canonicalized URL, and
	 * MUST point to an image file (e.g. a GIF, JPEG, or PNG image file) rather
	 * than to a web page containing an image. Service Providers MAY return the
	 * same image at different sizes, though it is recognized that no standard
	 * for describing images of various sizes currently exists. Note that this
	 * attribute SHOULD NOT be used to send down arbitrary photos taken by this
	 * User, but specifically profile photos of the User suitable for display
	 * when describing the User. Instead of the standard Canonical Values for
	 * type, this attribute defines the following Canonical Values to represent
	 * popular photo sizes: photo, thumbnail.
	 * 
	 * @return value allowed object is {@link List<MultiValuedAttribute> }
	 * 
	 */
	public List<MultiValuedAttribute> getPhotos() {
		return photos;
	}

	public void setPhotos(List<MultiValuedAttribute> value) {
		this.photos = value;
	}

	/**
	 * A physical mailing address for this User. Canonical Type Values of work,
	 * home, and other. The value attribute is a complex type with the following
	 * sub-attributes. All Sub-Attributes are OPTIONAL.
	 * 
	 * @return possible object is {@link List<Address> }
	 * 
	 */
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> value) {
		this.addresses = value;
	}

	/**
	 * A list of groups that the user belongs to, either thorough direct
	 * membership, nested groups, or dynamically calculated. The values are
	 * meant to enable expression of common group or role based access control
	 * models, although no explicit authorization model is defined. It is
	 * intended that the semantics of group membership and any behavior or
	 * authorization granted as a result of membership are defined by the
	 * Service Provider. The Canonical types "direct" and "indirect" are defined
	 * to describe how the group membership was derived. Direct group membership
	 * indicates the User is directly associated with the group and SHOULD
	 * indicate that Consumers may modify membership through the Group Resource.
	 * Indirect membership indicates User membership is transitive or dynamic
	 * and implies that Consumers cannot modify indirect group membership
	 * through the Group resource but MAY modify direct group membership through
	 * the Group resource which MAY influence indirect memberships. If the SCIM
	 * Service Provider exposes a Group resource, the value MUST be the "id"
	 * attribute of the corresponding Group resources to which the user belongs.
	 * Since this attribute is read-only, group membership changes MUST be
	 * applied via the Group Resource. READ-ONLY.
	 * 
	 * @return possible object is {@link List<MultiValuedAttribute> }
	 * 
	 */
	public List<MultiValuedAttribute> getGroups() {
		return groups;
	}

	public void setGroups(List<MultiValuedAttribute> value) {
		this.groups = value;
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
	public List<MultiValuedAttribute> getEntitlements() {
		return entitlements;
	}

	public void setEntitlements(List<MultiValuedAttribute> value) {
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
	public List<MultiValuedAttribute> getRoles() {
		return roles;
	}

	/**
	 * @param value
	 *            allowed object is {@link List<MultiValuedAttribute> }
	 */
	public void setRoles(List<MultiValuedAttribute> value) {
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

	@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
	@XmlType(name = "name", propOrder = { "formatted", "familyName", "givenName", "middleName", "honorificPrefix",
			"honorificSuffix" })
	public static class Name {

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

	/**
	 * A physical mailing address for this User. Canonical Type Values of work,
	 * home, and other. The value attribute is a complex type with the following
	 * sub-attributes. All Sub-Attributes are OPTIONAL.
	 */
	@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
	@XmlType(name = "address", propOrder = { "formatted", "streetAddress", "locality", "region", "postalCode",
			"country" })
	public static class Address extends MultiValuedAttribute {

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
		 * The full street address component, which may include house number,
		 * street name, P.O. box, and multi-line extended street address
		 * information. This attribute MAY contain newlines.
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
		 * 3166-1 alpha 2 "short" code format; e.g., the United States and
		 * Sweden are "US" and "SE", respectively.
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

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
	
}
