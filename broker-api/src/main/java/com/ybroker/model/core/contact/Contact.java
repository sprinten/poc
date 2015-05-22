package com.ybroker.model.core.contact;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.enunciate.doc.DocumentationExample;
import org.codehaus.enunciate.doc.ExampleType;

import com.ybroker.model.core.Unit;
import com.ybroker.model.core.base.MultiValuedAttribute;
import com.ybroker.model.core.base.Resource;

/**
 * <p>
 * Representation of a contact.
 * </p>
 */
@XmlType(name = "Contact")
@XmlRootElement(name = "Contact")
public abstract class Contact extends Resource {

	protected Name name;
	protected String displayName;
	protected String nickName;
	protected String title;

	private Unit organization;

	protected List<Address> addresses;
	protected List<MultiValuedAttribute> emails;
	protected List<MultiValuedAttribute> phoneNumbers;
	protected List<MultiValuedAttribute> ims;
	protected List<MultiValuedAttribute> photos;
	protected List<MultiValuedAttribute> groups;

	public Contact() {
		super();
	}

	public Unit getOrganization() {
		return organization;
	}

	public void setOrganization(Unit organization) {
		this.organization = organization;
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
}