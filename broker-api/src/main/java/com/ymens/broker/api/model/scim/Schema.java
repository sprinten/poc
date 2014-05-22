package com.ymens.broker.api.model.scim;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ymens.broker.api.model.generic.Resource;

/**
 * <p>
 * Resource Schema Representation.
 * </p>
 * 
 * <p>Schema Resources are READ-ONLY and identified using the following URI:
 * 'urn:scim:schemas:core:1.0'. Unlike other core Resources the schema Resource
 * MAY contain a complex object within a Sub-Attribute and all Attributes are
 * REQUIRED unless other specified.</p>
 * 
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(name = "Schema", propOrder = { "id", "name", "schemas", "description", "schema", "endpoint", "attributes", "meta" })
@XmlRootElement(name = "Schema")
public class Schema extends Resource {

	private String name;
	private String description;
	private String schema;
	private String endpoint;
	private List<SchemaAttribute> attributes;

	/**
	 * The Resource name. When applicable Service Providers MUST specify the
	 * name specified in the core schema specification; e.g., "User" or "Group".
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
	 * The Resource's human readable description. When applicable Service
	 * Providers MUST specify the description specified in the core schema
	 * specification.
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
	 * The Resource's associated schema URI; e.g., urn:scim:schemas:core:1.0.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@XmlElement(required = true)
	public String getSchema() {
		return schema;
	}

	/**
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSchema(String value) {
		this.schema = value;
	}

	/**
	 * The Resource's HTTP addressable endpoint relative to the Base URL; e.g.,
	 * /Users.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@XmlElement(required = true)
	public String getEndpoint() {
		return endpoint;
	}

	/**
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEndpoint(String value) {
		this.endpoint = value;
	}

	/**
	 * A complex type that specifies the set of Resource attributes.
	 * 
	 * @return
	 * 
	 */
	public List<SchemaAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<SchemaAttribute> attributes) {
		this.attributes = attributes;
	}

	@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
	@XmlType(name = "SchemaAttribute", propOrder = { "name", "type", "multiValued", "multiValuedAttributeChildName",
			"description", "schema", "readOnly", "required", "caseExact", "subAttributes" })
	public static class SchemaAttribute {

		private String name;
		private String type;
		private Boolean multiValued;
		private String multiValuedAttributeChildName;
		private String description;
		private String schema;
		private Boolean readOnly;
		private Boolean required;
		private Boolean caseExact;
		private List<SchemaSubAttribute> subAttributes;

		/**
		 * The attribute's name.
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
		 * The attribute's data type; e.g., String.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		@XmlElement(required = true)
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
		 * Boolean value indicating the attribute's plurality.
		 * 
		 * @return possible object is {@link Boolean }
		 */
		@XmlElement(required = true)
		public Boolean getMultiValued() {
			return multiValued;
		}

		/**
		 * @param value
		 *            allowed object is {@link Boolean }
		 */
		public void setMultiValued(Boolean value) {
			this.multiValued = value;
		}

		/**
		 * String value specifying the child XML element name; e.g., the
		 * 'emails' attribute value is 'email', 'phoneNumbers', is
		 * 'phoneNumber'. REQUIRED when the multiValued attribute value is true
		 * otherwise this attribute MUST be omitted.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getMultiValuedAttributeChildName() {
			return multiValuedAttributeChildName;
		}

		/**
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setMultiValuedAttributeChildName(String value) {
			this.multiValuedAttributeChildName = value;
		}

		/**
		 * The attribute's human readable description. When applicable Service
		 * Providers MUST specify the description specified in the core schema
		 * specification.
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
		 * The attribute's associated schema; e.g., urn:scim:schemas:core:1.0.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		@XmlElement(required = true)
		public String getSchema() {
			return schema;
		}

		/**
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setSchema(String value) {
			this.schema = value;
		}

		/**
		 * A Boolean value that specifies if the attribute is mutable.
		 * 
		 * @return possible object is {@link Boolean }
		 * 
		 */
		@XmlElement(required = true)
		public Boolean getReadOnly() {
			return readOnly;
		}

		/**
		 * @param value
		 *            allowed object is {@link Boolean }
		 * 
		 */
		public void setReadOnly(Boolean value) {
			this.readOnly = value;
		}

		/**
		 * A Boolean value that specifies if the attribute is required.
		 * 
		 * @return possible object is {@link Boolean }
		 * 
		 */
		@XmlElement(required = true)
		public Boolean getRequired() {
			return required;
		}

		/**
		 * @param value
		 *            allowed object is {@link Boolean }
		 * 
		 */
		public void setRequired(Boolean value) {
			this.required = value;
		}

		/**
		 * A Boolean value that specifies if the String attribute is case
		 * sensitive. The following multi-valued attributes are defined. There
		 * are no canonical type values defined and the primary value serves no
		 * useful purpose.
		 * 
		 * @return possible object is {@link Boolean }
		 * 
		 */
		@XmlElement(required = true)
		public Boolean getCaseExact() {
			return caseExact;
		}

		/**
		 * Sets the value of the caseExact property.
		 * 
		 * @param value
		 *            allowed object is {@link Boolean }
		 * 
		 */
		public void setCaseExact(Boolean value) {
			this.caseExact = value;
		}

		/**
		 * A list specifying the contained attributes. OPTIONAL.
		 * 
		 * @return possible object is {@link List<SchemaSubAttribute> }
		 * 
		 */
		@XmlElement(required = false)
		public List<SchemaSubAttribute> getSubAttributes() {
			return subAttributes;
		}

		/**
		 * @param value
		 *            allowed object is {@link List<SchemaSubAttribute> }
		 * 
		 */
		public void setSubAttributes(List<SchemaSubAttribute> value) {
			this.subAttributes = value;
		}

		@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
		@XmlType(name = "SchemaSubAttribute", propOrder = { "name", "type", "description", "readOnly", "required",
				"caseExact", "canonicalValues" })
		public static class SchemaSubAttribute {

			private String name;
			private String type;
			private String description;
			private Boolean readOnly;
			private Boolean required;
			private Boolean caseExact;
			private List<String> canonicalValues;

			/**
			 * he attribute's name.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
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
			 * The attribute's data type; e.g., String.
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
			 * The attribute's human readable description. When applicable
			 * Service Providers MUST specify the description specified in the
			 * core schema specification.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
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
			 * A Boolean value that specifies if the attribute is mutable.
			 * 
			 * @return possible object is {@link Boolean }
			 * 
			 */
			public Boolean getReadOnly() {
				return readOnly;
			}

			/**
			 * @param value
			 *            allowed object is {@link Boolean }
			 * 
			 */
			public void setReadOnly(Boolean value) {
				this.readOnly = value;
			}

			/**
			 * A Boolean value that specifies if the attribute is required.
			 * 
			 * @return possible object is {@link Boolean }
			 * 
			 */
			public Boolean getRequired() {
				return required;
			}

			/**
			 * @param value
			 *            allowed object is {@link Boolean }
			 * 
			 */
			public void setRequired(Boolean value) {
				this.required = value;
			}

			/**
			 * A Boolean value that specifies if the String attribute is case
			 * sensitive.
			 * 
			 * @return possible object is {@link Boolean }
			 * 
			 */
			public Boolean getCaseExact() {
				return caseExact;
			}

			/**
			 * @param value
			 *            allowed object is {@link Boolean }
			 * 
			 */
			public void setCaseExact(Boolean value) {
				this.caseExact = value;
			}

			/**
			 * A collection of canonical values. When applicable Service
			 * Providers MUST specify the canonical types specified in the core
			 * schema specification; e.g.,"work","home". OPTIONAL.
			 */
			public List<String> getCanonicalValues() {
				if (canonicalValues == null) {
					canonicalValues = new ArrayList<String>();
				}
				return this.canonicalValues;
			}

			public void setCanonicalValues(List<String> canonicalValues) {
				this.canonicalValues = canonicalValues;
			}
		}

	}
}
