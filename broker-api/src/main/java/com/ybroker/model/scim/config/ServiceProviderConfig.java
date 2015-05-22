package com.ybroker.model.scim.config;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.enunciate.doc.DocumentationExample;
import org.codehaus.enunciate.doc.ExampleType;

import com.google.gson.Gson;
import com.ybroker.model.core.base.Resource;

/**
 * <p>
 * Service Provider Configuration Representation. A Service Provider is a web
 * application that provides identity information via the SCIM protocol.
 * </p>
 * 
 * <p>
 * The Service Provider Configuration Resource enables a Service Provider to
 * expose its compliance with the SCIM specification in a standardized form as
 * well as provide additional implementation details to Consumers. All
 * attributes are READ-ONLY.
 * </p>
 */

@XmlType(name = "ServiceProviderConfig", propOrder = { "schemas", "id", "externalId", "documentationUrl", "patch",
		"bulk", "filter", "changePassword", "sort", "etag", "authenticationSchemes", "xmlDataFormat", "meta" })
@XmlRootElement(name = "ServiceProviderConfig")
public class ServiceProviderConfig extends Resource {

	private String documentationUrl;
	private Patch patch;
	private Bulk bulk;
	private Filter filter;
	private ChangePassword changePassword;
	private Sort sort;
	private Etag etag;
	private List<AuthenticationScheme> authenticationSchemes;
	private XmlDataFormat xmlDataFormat;

	public ServiceProviderConfig() {
		super();
	}

	/**
	 * An HTTP addressable URL pointing to the Service Provider's human
	 * consumable help documentation.
	 * 
	 * @return possible object is {@link String }
	 */
	@DocumentationExample(validTypes = ExampleType.JSON, value = "http://provider.com/api")
	public String getDocumentationUrl() {
		return documentationUrl;
	}

	public void setDocumentationUrl(String value) {
		this.documentationUrl = value;
	}

	/**
	 * A complex type that specifies PATCH configuration options. REQUIRED.
	 * 
	 * @return possible object is {@link Patch }
	 * 
	 */
	@XmlElement(required = true)
	public Patch getPatch() {
		return patch;
	}

	public void setPatch(Patch value) {
		this.patch = value;
	}

	/**
	 * A complex type that specifies BULK configuration options. REQUIRED
	 * 
	 * @return possible object is {@link Bulk }
	 * 
	 */
	@XmlElement(required = true)
	public Bulk getBulk() {
		return bulk;
	}

	public void setBulk(Bulk value) {
		this.bulk = value;
	}

	/**
	 * A complex type that specifies FILTER options. REQUIRED.
	 * 
	 * @return possible object is {@link Filter }
	 * 
	 */
	@XmlElement(required = true)
	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter value) {
		this.filter = value;
	}

	/**
	 * A complex type that specifies Change Password configuration options.
	 * REQUIRED.
	 * 
	 * @return possible object is {@link ChangePassword }
	 * 
	 */
	@XmlElement(required = true)
	public ChangePassword getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(ChangePassword value) {
		this.changePassword = value;
	}

	/**
	 * A complex type that specifies Sort configuration options. REQUIRED.
	 * 
	 * @return possible object is {@link Sort }
	 * 
	 */
	@XmlElement(required = true)
	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort value) {
		this.sort = value;
	}

	/**
	 * A complex type that specifies Etag configuration options. REQUIRED.
	 * 
	 * @return possible object is {@link Etag }
	 * 
	 */
	@XmlElement(required = true)
	public Etag getEtag() {
		return etag;
	}

	public void setEtag(Etag value) {
		this.etag = value;
	}

	/**
	 * A complex type that specifies supported Authentication Scheme properties.
	 * Instead of the standard Canonical Values for type, this attribute defines
	 * the following Canonical Values to represent common schemes: oauth,
	 * oauth2, oauthbearertoken, httpbasic, and httpdigest. To enable seamless
	 * discovery of configuration, the Service Provider SHOULD, with the
	 * appropriate security considerations, make the authenticationSchemes
	 * attribute publicly accessible without prior authentication. REQUIRED.
	 * 
	 * @return possible object is {@link List<AuthenticationScheme> }
	 */
	@XmlElement(required = true)
	public List<AuthenticationScheme> getAuthenticationSchemes() {
		return authenticationSchemes;
	}

	public void setAuthenticationSchemes(List<AuthenticationScheme> value) {
		this.authenticationSchemes = value;
	}

	/**
	 * A complex type that specifies whether the XML data format is supported.
	 * REQUIRED.
	 * 
	 * @return possible object is {@link XmlDataFormat }
	 */
	@XmlElement(required = true)
	public XmlDataFormat getXmlDataFormat() {
		return xmlDataFormat;
	}

	public void setXmlDataFormat(XmlDataFormat value) {
		this.xmlDataFormat = value;
	}

	/**
	 * A complex type that specifies BULK configuration options. REQUIRED
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "Bulk", propOrder = { "supported", "maxOperations", "maxPayloadSize" })
	public static class Bulk {

		private Boolean supported;
		private Integer maxOperations;
		private Integer maxPayloadSize;

		/**
		 * Boolean value specifying whether the operation is supported.
		 * REQUIRED.
		 * 
		 * @return possible object is {@link Boolean }
		 * 
		 */
		@XmlElement(required = true)
		public Boolean getSupported() {
			return supported;
		}

		/**
		 * @param value
		 *            allowed object is {@link Boolean }
		 * 
		 */
		public void setSupported(Boolean value) {
			this.supported = value;
		}

		/**
		 * An integer value specifying the maximum number of operations.
		 * REQUIRED.
		 * 
		 * @return possible object is {@link Integer }
		 * 
		 */
		@XmlElement(required = true)
		public Integer getMaxOperations() {
			return maxOperations;
		}

		/**
		 * @param value
		 *            allowed object is {@link Integer }
		 * 
		 */
		public void setMaxOperations(Integer value) {
			this.maxOperations = value;
		}

		/**
		 * An integer value specifying the maximum payload size in bytes.
		 * REQUIRED.
		 * 
		 * @return possible object is {@link Integer }
		 * 
		 */
		@XmlElement(required = true)
		public Integer getMaxPayloadSize() {
			return maxPayloadSize;
		}

		/**
		 * @param value
		 *            allowed object is {@link Integer }
		 * 
		 */
		public void setMaxPayloadSize(Integer value) {
			this.maxPayloadSize = value;
		}

	}

	/**
	 * A complex type that specifies Change Password configuration options.
	 * REQUIRED.
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "ChangePassword", propOrder = { "supported" })
	public static class ChangePassword {

		private Boolean supported;

		/**
		 * Boolean value specifying whether the operation is supported.
		 * REQUIRED.
		 * 
		 * @return possible object is {@link Boolean }
		 * 
		 */
		@XmlElement(required = true)
		public Boolean getSupported() {
			return supported;
		}

		/**
		 * @param value
		 *            allowed object is {@link Boolean }
		 * 
		 */
		public void setSupported(Boolean value) {
			this.supported = value;
		}

	}

	/**
	 * A complex type that specifies Etag configuration options. REQUIRED.
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "Etag", propOrder = { "supported" })
	public static class Etag {

		private Boolean supported;

		/**
		 * Boolean value specifying whether the operation is supported.
		 * REQUIRED.
		 * 
		 * @return possible object is {@link Boolean }
		 * 
		 */
		@XmlElement(required = true)
		public Boolean getSupported() {
			return supported;
		}

		/**
		 * @param value
		 *            allowed object is {@link Boolean }
		 * 
		 */
		public void setSupported(Boolean value) {
			this.supported = value;
		}

	}

	/**
	 * A complex type that specifies FILTER options. REQUIRED.
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "Filter", propOrder = { "supported", "maxResults" })
	public static class Filter {

		private Boolean supported;
		private Integer maxResults;

		/**
		 * Boolean value specifying whether the operation is supported.
		 * REQUIRED.
		 * 
		 * @return possible object is {@link Boolean }
		 * 
		 */
		@XmlElement(required = true)
		public Boolean getSupported() {
			return supported;
		}

		/**
		 * @param value
		 *            allowed object is {@link Boolean }
		 * 
		 */
		public void setSupported(Boolean value) {
			this.supported = value;
		}

		/**
		 * Integer value specifying the maximum number of Resources returned in
		 * a response. REQUIRED.
		 * 
		 * @return possible object is {@link Integer }
		 * 
		 */
		@XmlElement(required = true)
		public Integer getMaxResults() {
			return maxResults;
		}

		/**
		 * @param value
		 *            allowed object is {@link Integer }
		 * 
		 */
		public void setMaxResults(Integer value) {
			this.maxResults = value;
		}

	}

	/**
	 * A complex type that specifies PATCH configuration options. REQUIRED.
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "Patch", propOrder = { "supported" })
	public static class Patch {

		private Boolean supported;

		/**
		 * Boolean value specifying whether the operation is supported.
		 * REQUIRED.
		 * 
		 * @return possible object is {@link Boolean }
		 * 
		 */
		@XmlElement(required = true)
		public Boolean getSupported() {
			return supported;
		}

		/**
		 * @param value
		 *            allowed object is {@link Boolean }
		 * 
		 */
		public void setSupported(Boolean value) {
			this.supported = value;
		}

	}

	/**
	 * A complex type that specifies Sort configuration options. REQUIRED.
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "Sort", propOrder = { "supported" })
	public static class Sort {

		private Boolean supported;

		/**
		 * Boolean value specifying whether the operation is supported.
		 * REQUIRED.
		 * 
		 * @return possible object is {@link Boolean }
		 */
		@XmlElement(required = true)
		public Boolean getSupported() {
			return supported;
		}

		/**
		 * @param value
		 *            allowed object is {@link Boolean }
		 */
		public void setSupported(Boolean value) {
			this.supported = value;
		}

	}

	/**
	 * A complex type that specifies whether the XML data format is supported.
	 * REQUIRED.
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "XmlDataFormat", propOrder = { "supported" })
	public static class XmlDataFormat {

		private Boolean supported;

		/**
		 * Boolean value specifying whether the operation is supported.
		 * REQUIRED.
		 * 
		 * @return possible object is {@link Boolean }
		 * 
		 */
		@XmlElement(required = true)
		public Boolean getSupported() {
			return supported;
		}

		/**
		 * @param value
		 *            allowed object is {@link Boolean }
		 * 
		 */
		public void setSupported(Boolean value) {
			this.supported = value;
		}

	}

	/**
	 * A complex type that specifies supported Authentication Scheme properties.
	 * Instead of the standard Canonical Values for type, this attribute defines
	 * the following Canonical Values to represent common schemes: oauth,
	 * oauth2, oauth bearer token, http basic, and http digest. To enable seamless
	 * discovery of configuration, the Service Provider SHOULD, with the
	 * appropriate security considerations, make the authenticationSchemes
	 * attribute publicly accessible without prior authentication. REQUIRED.
	 */
	@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
	@XmlType(name = "AuthenticationScheme", propOrder = { "name", "description", "specUrl", "documentationUrl" })
	public static class AuthenticationScheme {

		private String name;
		private String description;
		private String specUrl;
		private String documentationUrl;

		/**
		 * The common authentication scheme name; e.g., HTTP Basic. REQUIRED.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		@XmlElement(required = true)
		public String getName() {
			return name;
		}

		/**
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setName(String value) {
			this.name = value;
		}

		/**
		 * A description of the Authentication Scheme. REQUIRED.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		@XmlElement(required = true)
		public String getDescription() {
			return description;
		}

		/**
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setDescription(String value) {
			this.description = value;
		}

		/**
		 * A HTTP addressable URL pointing to the Authentication Scheme's
		 * specification. OPTIONAL.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getSpecUrl() {
			return specUrl;
		}

		/**
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setSpecUrl(String value) {
			this.specUrl = value;
		}

		/**
		 * A HTTP addressable URL pointing to the Authentication Scheme's usage
		 * documentation. OPTIONAL.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getDocumentationUrl() {
			return documentationUrl;
		}

		/**
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setDocumentationUrl(String value) {
			this.documentationUrl = value;
		}
	}

//	@Override
//	public String toString() {
//		return "ServiceProviderConfig [documentationUrl=" + documentationUrl + ", patch=" + patch + ", bulk=" + bulk
//				+ ", filter=" + filter + ", changePassword=" + changePassword + ", sort=" + sort + ", etag=" + etag
//				+ ", authenticationSchemes=" + authenticationSchemes + ", xmlDataFormat=" + xmlDataFormat
//				+ ", " + super.toString() + "]";
//	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
