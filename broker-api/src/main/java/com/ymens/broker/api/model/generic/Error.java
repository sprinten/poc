package com.ymens.broker.api.model.generic;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>
 * Error Representation
 * </p>
 * 
 * <p>
 * The Protocol uses the response status codes defined in HTTP to indicate
 * operation success or failure. In addition to returning a HTTP response code
 * implementers MUST return the errors in the body of the response in the client
 * requested format containing the error response and, per the HTTP
 * specification, human-readable explanations.
 * </p>
 * 
 * <h3>Error Codes</h3>
 * 
 * <p>
 * Implementers SHOULD handle the identified errors as described below.
 * </p>
 * 
 * <table border="0" class="bodyTable table table-striped table-bordered table-hover">
 * <tr>
 * <th>Code</th>
 * <th>Applicability</th>
 * <th>Suggested Explanation</th>
 * </tr>
 * 
 * <tr>
 * <td>307 TEMPORARY REDIRECT</td>
 * <td>GET,POST,PUT,PATCH,DELETE</td>
 * <td>The client is directed to repeat the same HTTP request at the location
 * identified. The client SHOULD NOT use the location provided in the response
 * as a permanent reference to the resource and SHOULD continue to use the
 * original request URI
 * </tr>
 * 
 * <tr>
 * <td>308 PERMANENT REDIRECT</td>
 * <td>GET,POST,PUT,PATCH,DELETE</td>
 * <td>The client is directed to repeat the same HTTP request at the location
 * identified. The client SHOULD use the location provided in the response as a
 * permanent reference to the resource.
 * </tr>
 * 
 * 
 * <tr>
 * <td>400 BAD REQUEST</td>
 * <td>GET,POST,PUT,PATCH,DELETE</td>
 * <td>Request is unparseable, syntactically incorrect, or violates schema</td>
 * </tr>
 * <tr>
 * <td>401 UNAUTHORIZED</td>
 * <td>GET,POST,PUT,PATCH,DELETE</td>
 * <td>Authorization failure</td>
 * </tr>
 * <tr>
 * <td>403 FORBIDDEN</td>
 * <td>GET,POST,PUT,PATCH,DELETE</td>
 * <td>Server does not support requested operation</td>
 * </tr>
 * <tr>
 * <td>404 NOT FOUND</td>
 * <td>GET,POST,PUT,PATCH,DELETE</td>
 * <td>Specified resource does not exist</td>
 * </tr>
 * <tr>
 * <td>409 CONFLICT</td>
 * <td>POST,PUT,PATCH,DELETE</td>
 * <td>The specified version number does not match the resource's latest version
 * number or a Service Provider refused to create a new, duplicate resource</td>
 * </tr>
 * <tr>
 * <td>412 PRECONDITION FAILED</td>
 * <td>PUT,PATCH,DELETE</td>
 * <td>Failed to update as Resource {id} changed on the server last retrieved</td>
 * </tr>
 * <tr>
 * <td>413 REQUEST ENTITY TOO LARGE</td>
 * <td>POST</td>
 * <td>{"maxOperations": 1000,"maxPayload": 1048576}</td>
 * </tr>
 * <tr>
 * <td>500 INTERNAL SERVER ERROR</td>
 * <td>GET,POST,PUT,PATCH,DELETE</td>
 * <td>An internal error. Implementers SHOULD provide descriptive debugging
 * advice</td>
 * </tr>
 * <tr>
 * <td>501 NOT IMPLEMENTED</td>
 * <td>GET,POST,PUT,PATCH,DELETE</td>
 * <td>Service Provider does not support the request operation; e.g., PATCH</td>
 * </tr>
 * </table>
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(name = "Error", propOrder = { "description", "code", "uri", "attributes", "parameters" })
public class Error {

	private String description;
	private String code;
	private String uri;
	private Set<String> attributes = new TreeSet<String>();
	private List<String> parameters = new LinkedList<String>();

	/**
	 * A string indicating the HTTP response code. REQUIRED.
	 * 
	 * @return
	 */
	@XmlElement(required = true)
	@JsonProperty(value="code" ,required = true)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * A human-readable explanation of the error. REQUIRED.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@XmlElement(required = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the uri property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUri() {
		return uri;
	}

	public void setUri(String value) {
		this.uri = value;
	}

	/**
	 * The affected fields/attributes.
	 * 
	 * @return
	 */
	public Set<String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Set<String> fields) {
		this.attributes = fields;
	}

	/**
	 * The invalid input parameters.
	 * 
	 * @return
	 */
	public List<String> getParameters() {
		return parameters;
	}

	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}
}
