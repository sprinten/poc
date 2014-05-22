package com.ymens.broker.api.model.generic;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Each Resource (Users, Groups, etc.) includes a set of common attributes.
 * These attributes MUST be included in all Resources, including any extended
 * Resource types. It is not necessary to specify the schemas attribute if the
 * Resource is fully defined in this document as the core schema is implicitly
 * included.
 */
@XmlTransient
public abstract class CoreResource extends Resource {

	private String externalId;

	public CoreResource() {
		super();
	}

	/**
	 * An identifier for the Resource as defined by the Service Consumer. The
	 * externalId may simplify identification of the Resource between Service
	 * Consumer and Service provider by allowing the Consumer to refer to the
	 * Resource with its own identifier, obviating the need to store a local
	 * mapping between the local identifier of the Resource and the identifier
	 * used by the Service Provider. Each Resource MAY include a non-empty
	 * externalId value. The value of the externalId attribute is always issued
	 * be the Service Consumer and can never be specified by the Service
	 * Provider. The Service Provider MUST always interpret the externalId as
	 * scoped to the Service Consumer's tenant.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getExternalId() {
		return externalId;
	}

	/**
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExternalId(String value) {
		this.externalId = value;
	}
	@Override
	public String toString() {
		return "CoreResource [externalId=" + externalId + ", " + super.toString() + "]";
	}
}
