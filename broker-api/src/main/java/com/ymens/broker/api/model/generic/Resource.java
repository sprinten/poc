package com.ymens.broker.api.model.generic;

import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.enunciate.doc.DocumentationExample;
import org.codehaus.enunciate.doc.ExampleType;
import org.codehaus.enunciate.jaxrs.TypeHint;

import com.ymens.broker.api.model.scim.internal.Meta;

/**
 * <p>
 * Each Resource (Users, Groups, etc.) includes a set of common attributes.
 * These attributes MUST be included in all Resources, including any extended
 * Resource types. It is not necessary to specify the schemas attribute if the
 * Resource is fully defined in this document as the core schema is implicitly
 * included.
 * </p>
 */
@XmlTransient
public abstract class Resource {

	private String id;
	private Meta meta;

	private List<String> schemas;

	public Resource() {
		super();
	}

	/**
	 * The schemas attribute is an array of Strings which allows introspection
	 * of the supported schema version as well any schema extensions supported.
	 * Each String value must be a unique URI. All representations MUST include
	 * a non-zero value array with value(s) of the URIs supported by that
	 * representation. Duplicate values MUST NOT be included. Value order is not
	 * specified and MUST not impact behavior.
	 * 
	 * @return
	 */
	@XmlElement(required = true)
	public List<String> getSchemas() {
		return schemas;
	}

	public void setSchemas(List<String> schemas) {
		this.schemas = schemas;
	}

	/**
	 * Unique identifier for the SCIM Resource as defined by the Service
	 * Provider. Each representation of the Resource MUST include a non-empty id
	 * value. This identifier MUST be unique across the Service Provider's
	 * entire set of Resources. It MUST be a stable, non-reassignable identifier
	 * that does not change when the same Resource is returned in subsequent
	 * requests. The value of the id attribute is always issued by the Service
	 * Provider and MUST never be specified by the Service Consumer. bulkId: is
	 * a reserved keyword and MUST NOT be used in the unique identifier.
	 * REQUIRED and READ-ONLY.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@DocumentationExample(validTypes = ExampleType.JSON, value = "1c35cee0-db4d-11e3-a356-0002a5d5c51b")
	@TypeHint(value = UUID.class)
	@XmlElement(required = true)
	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

	/**
	 * A complex attribute containing resource metadata. All sub-attributes are
	 * OPTIONAL
	 * 
	 * @return possible object is {@link Meta }
	 * 
	 */
	public Meta getMeta() {
		return meta;
	}

	/**
	 * @param value
	 *            allowed object is {@link Meta }
	 */
	public void setMeta(Meta value) {
		this.meta = value;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", meta=" + meta + ", schemas=" + schemas + ", " + super.toString()
				+ "]";
	}
}
