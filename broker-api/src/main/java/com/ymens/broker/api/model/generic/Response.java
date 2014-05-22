package com.ymens.broker.api.model.generic;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.enunciate.jaxrs.TypeHint;

/**
 * <p>
 * Response Body Generic Representation.
 * <p>
 * 
 * The Protocol uses the response status codes defined in HTTP Section 10
 * [RFC2616] to indicate operation success or failure. In addition to returning
 * a HTTP response code implementers MUST return the errors in the body of the
 * response in the client requested format containing the error response and,
 * per the HTTP specification, human- readable explanations.
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(name = "Response", propOrder = { "resource", "totalResults", "itemsPerPage", "startIndex", "resources",
		"errors" })
@XmlRootElement(name = "Response")
public class Response<T extends Resource> {

	private T resource;
	private Long totalResults;
	private Integer itemsPerPage;
	private Long startIndex;
	private List<T> resources;
	private List<Error> errors;

	/**
	 * The resource
	 * 
	 * @return possible object is {@link Resource }
	 * 
	 */
	@TypeHint(value = Resource.class)
	public T getResource() {
		return resource;
	}

	public void setResource(T value) {
		this.resource = value;
	}

	/**
	 * Non-negative Integer. Specifies the total number of results matching the
	 * Consumer query; e.g., 1000.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Long value) {
		this.totalResults = value;
	}

	/**
	 * Non-negative Integer. Specifies the number of search results returned in
	 * a query response page; e.g., 10.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(Integer value) {
		this.itemsPerPage = value;
	}

	/**
	 * The 1-based index of the first result in the current set of search
	 * results; e.g., 1.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Long value) {
		this.startIndex = value;
	}

	/**
	 * The resource list
	 * 
	 * @return possible object is {@link Response.Resources }
	 * 
	 */
	@XmlElement(name = "Resources")
	public List<T> getResources() {
		return resources;
	}

	public void setResources(List<T> value) {
		this.resources = value;
	}

	/**
	 * The list of errors encountered by the service provider.
	 * 
	 * @return possible object is {@link Response.Errors }
	 * 
	 */
	@XmlElement(name = "Errors")
	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> value) {
		this.errors = value;
	}
}
