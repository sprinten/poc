package com.ymens.broker.api.endpoint.generic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ymens.broker.api.model.generic.Filter;
import com.ymens.broker.api.model.generic.Resource;

public interface ReadWriteEndpoint<T extends Resource> {

	/**
	 * <p>
	 * To create new Resources, clients send POST requests to the Resource
	 * endpoint.
	 * </p>
	 * 
	 * <p>
	 * Successful Resource creation is indicated with a 201 ("Created") response
	 * code. Upon successful creation, the response body MUST contain the newly
	 * created Resource. Since the server is free to alter and/or ignore POSTed
	 * content, returning the full representation can be useful to the client,
	 * enabling it to correlate the client and server views of the new Resource.
	 * When a Resource is created, its URI must be returned in the response
	 * Location header.
	 * </p>
	 * 
	 * <p>
	 * If the Service Provider determines creation of the requested Resource
	 * conflicts with existing resources; e.g., a User Resource with a duplicate
	 * userName, the Service Provider MUST return a 409 error and SHOULD
	 * indicate the conflicting attribute(s) in the body of the response.
	 * </p>
	 * 
	 * @param resource
	 *            The resource details.
	 * 
	 * @HTTP 201 Created
	 * @HTTP 409 Conflict
	 */
	public abstract javax.ws.rs.core.Response post(T resource);

	/**
	 * To retrieve a known Resource, clients send GET requests to the Resource
	 * endpoint
	 * 
	 * @param id
	 *            The resource ID
	 * @return The resource details
	 * @HTTP 200 Success
	 * @HTTP 404 Not found
	 */
	public abstract javax.ws.rs.core.Response get(String id);

	/**
	 * SCIM defines a standard set of operations that can be used to filter,
	 * sort, and paginate response results. The operations are specified by
	 * adding query parameters to the Resource's endpoint. Service Providers MAY
	 * support additional query parameters not specified here, and Providers
	 * SHOULD ignore any query parameters they don't recognize.
	 * 
	 * List/Query Resources
	 * 
	 * @param attributes
	 *            Consumers MAY request a partial Resource representation on any
	 *            operation that returns a Resource within the response by
	 *            specifying the URL query parameter 'attributes'. When
	 *            specified, each Resource returned MUST contain the minimal set
	 *            of Resource attributes and, MUST contain no other attributes
	 *            or Sub-Attributes than those explicitly requested. The query
	 *            parameter attributes value is a comma separated list of
	 *            Resource attribute names in standard, attribute notation form
	 *            (e.g. userName, name, emails).
	 * @param filter
	 *            Request a subset of Resources by specifying the 'filter' URL
	 *            query parameter containing a filter expression.
	 * @param sortBy
	 *            The sortBy parameter specifies the attribute whose value SHALL
	 *            be used to order the returned responses.
	 * @param sortOrder
	 *            The order in which the sortBy parameter is applied. Allowed
	 *            values are "ascending" and "descending".
	 * @param startIndex
	 *            The 1-based index of the first search result.
	 * @param count
	 *            Non-negative Integer. Specifies the desired maximum number of
	 *            search results per page
	 * 
	 * @return The resource list
	 * @HTTP 200 Success
	 * @HTTP 404 Not found
	 */
	public abstract javax.ws.rs.core.Response list(List<String> attributes, Filter filter, String sortBy,
			String sortOrder, Integer startIndex, Integer count);

	/**
	 * <p>
	 * PATCH is OPTIONAL. PATCH enables consumers to send only those attributes
	 * requiring modification, reducing network and processing overhead.
	 * Attributes may be deleted, replaced, merged, or added in a single
	 * request.
	 * </p>
	 * 
	 * <p>
	 * The body of a PATCH request MUST contain a partial Resource with the
	 * desired modifications. The server MUST return either a 200 OK response
	 * code and the entire Resource (subject to the "attributes" query parameter
	 * - see Additional Retrieval Query Parameters) within the response body, or
	 * a 204 No Content response code and the appropriate response headers for a
	 * successful PATCH request. The server MUST return a 200 OK if the
	 * "attributes" parameter is specified on the request.
	 * </p>
	 * 
	 * <p>
	 * The server MUST process a PATCH request by first removing any attributes
	 * specified in the meta.attributes Sub-Attribute (if present) and then
	 * merging the attributes in the PATCH request body into the Resource.
	 * </p>
	 * 
	 * <p>
	 * The meta.attributes Sub-Attribute MAY contain a list of attributes to be
	 * removed from the Resource. If the PATCH request body contains an
	 * attribute that is present in the meta.attributes list, the attribute on
	 * the Resource is replaced with the value from the PATCH body. If the
	 * attribute is complex the attribute name must be a path to a Sub-Attribute
	 * in standard attribute notation; e.g., name.givenName.
	 * </p>
	 * 
	 * <p>
	 * Attributes that exist in the PATCH request body but not in the
	 * meta.attributes Sub-Attribute will be either be updated or added to the
	 * Resource according to the following rules:
	 * </p>
	 * 
	 * <ul>
	 * <li><b>Singular attributes: </b>Singular attributes in the PATCH request
	 * body replace the attribute on the Resource.</li>
	 * <li><b>Complex attributes: </b>Complex Sub-Attribute values in the PATCH
	 * request body are merged into the complex attribute on the Resource.</li>
	 * <li><b>Multi-valued attributes: </b>An attribute value in the PATCH
	 * request body is added to the value collection if the value does not exist
	 * and merged if a matching value is present. Values are matched by
	 * comparing the value Sub-Attribute from the PATCH request body to the
	 * value Sub-Attribute of the Resource. Attributes that do not have a value
	 * Sub-Attribute; e.g., addresses, or do not have unique value
	 * Sub-Attributes cannot be matched and must instead be deleted then added.
	 * Specific values can be removed from a Resource by adding an "operation"
	 * Sub-Attribute with the value "delete" to the attribute in the PATCH
	 * request body. As with adding/updating attribute value collections, the
	 * value to delete is determined by comparing the value Sub-Attribute from
	 * the PATCH request body to the value Sub-Attribute of the Resource.
	 * Attributes that do not have a value Sub-Attribute or that have a
	 * non-unique value Sub-Attribute are matched by comparing all Sub-Attribute
	 * values from the PATCH request body to the Sub-Attribute values of the
	 * Resource. A delete operation is ignored if the attribute's name is in the
	 * meta.attributes list. If the requested value to delete does not match a
	 * unique value on the Resource the server MAY return a HTTP 400 error.</li>
	 * </ul>
	 * 
	 * @param resource
	 *            The resource details
	 * @param id
	 *            The resource ID
	 * 
	 * @HTTP 200 OK
	 * @HTTP 204 No Content
	 */
	public abstract javax.ws.rs.core.Response patch(T resource, String id);

	/**
	 * PUT performs a full update. Consumers must retrieve the entire Resource
	 * and PUT the desired modifications as the operation overwrites all
	 * previously stored data with the exception of the password attribute. If
	 * the password attribute of the User resource is unspecified, it should be
	 * left in-tact. Since this performs a full update, Consumers MAY send
	 * read-only attributes of the retrieved resource and Service Provider MUST
	 * ignore any read-only attributes that are present in the payload of a PUT
	 * request. Unless otherwise specified a successful PUT operation returns a
	 * 200 OK response code and the entire Resource within the response body,
	 * enabling the Consumer to correlate the Consumer's and Provider's views of
	 * the updated Resource.
	 * 
	 * @param resource
	 *            The resource details
	 * @param id
	 *            The resource ID
	 * @HTTP 200 Success
	 * @HTTP 404 Not found
	 */
	public abstract javax.ws.rs.core.Response put(T resource, String id);

	/**
	 * <p>
	 * Consumers request Resource removal via DELETE. Service Providers MAY
	 * choose not to permanently delete the Resource, but MUST return a 404
	 * error code for all operations associated with the previously deleted Id.
	 * Service Providers MUST also omit the Resource from future query results.
	 * In addition the Service Provider MUST not consider the deleted resource
	 * in conflict calculation. For example if a User resource is deleted, a
	 * CREATE request for a User resource with the same userName as the
	 * previously deleted resource should not fail with a 409 error due to
	 * userName conflict.
	 * </p>
	 * 
	 * 
	 * @param id
	 *            The id of the resource to delete
	 * @return A HTTP Response
	 */
	public abstract javax.ws.rs.core.Response delete(String id, HttpServletRequest request);

}