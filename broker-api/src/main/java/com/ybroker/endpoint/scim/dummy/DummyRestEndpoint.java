package com.ybroker.endpoint.scim.dummy;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.codehaus.enunciate.jaxrs.TypeHint;

import com.ybroker.endpoint.generic.ReadWriteEndpoint;
import com.ybroker.model.api.Filter;
import com.ybroker.model.api.Response;
import com.ybroker.model.core.base.Meta;
import com.ybroker.model.core.base.Resource;

/**
 * <p>
 * The protocol specifies well known endpoints and HTTP methods for managing
 * Resources defined in the core schema; i.e., User and Group Resources
 * correspond to /Users and /Groups respectively. Service Providers that support
 * extended Resources SHOULD define Resource endpoints using the established
 * convention; pluralize the Resource name defined in the extended schema by
 * appending an 's'. Given there are cases where Resource pluralization is
 * ambiguous; e.g., a Resource named 'person' is legitimately 'persons' and
 * 'people' Consumers SHOULD discover Resource endpoints via the Schema
 * Sub-Attribute 'endpoint'.
 * </p>
 * 
 * <ul>
 * <li><b>GET: </b> Retrieves a complete or partial Resource.</li>
 * <li><b>POST: </b> Create new Resource or bulk modify Resources.</li>
 * <li><b>PUT: </b> Modifies a Resource with a complete, Consumer specified
 * Resource (replace).</li>
 * <li><b>PATCH: </b> Modifies a Resource with a set of Consumer specified
 * changes (partial update).</li>
 * <li><b>DELETE: </b> Deletes a Resource.</li>
 * </ul>
 * 
 * <h3>Defined Endpoints</h3>
 * 
 * <table border="0" class="bodyTable table table-striped table-bordered table-hover">
 * <tr>
 * <th>Resource</th>
 * <th>Endpoint</th>
 * <th>Operations</th>
 * <th>Description</th>
 * </tr>
 * 
 * <tr>
 * <td>User</td>
 * <td>/Users</td>
 * <td>GET, POST, PUT, PATCH, DELETE</td>
 * <td>Retrieve/Add/Modify Users</td>
 * </tr>
 * 
 * <tr>
 * <td>Group</td>
 * <td>/Groups</td>
 * <td>GET, POST, PUT, PATCH, DELETE</td>
 * <td>Retrieve/Add/Modify Groups</td>
 * </tr>
 * 
 * <tr>
 * <td>Service Provider Configuration</td>
 * <td>/ServiceProviderConfigs</td>
 * <td>GET</td>
 * <td>Retrieve the Service Provider's Configuration</td>
 * </tr>
 * 
 * <tr>
 * <td>Schema</td>
 * <td>/Schema</td>
 * <td>GET</td>
 * <td>Retrieve a Resource's Schema</td>
 * </tr>
 * 
 * <tr>
 * <td>Bulk</td>
 * <td>/Bulk</td>
 * <td>POST</td>
 * <td>Bulk modify Resources</td>
 * </tr>
 * 
 * </table>
 * 
 * 
 * 
 * <p>
 * All requests to the Service Provider are made via HTTP operations on a URL
 * derived from the Base URL. Responses are returned in the body of the HTTP
 * response, formatted as JSON or XML, depending on what is requested. Response
 * and error codes SHOULD be transmitted via the HTTP status code of the
 * response (if possible), and SHOULD also be specified in the body of the
 * response.
 * </p>
 * 
 * <h3>Pagination</h3>
 * 
 * <p>
 * Pagination parameters can be used together to "page through" large numbers of
 * Resources so as not to overwhelm the Consumer or Service Provider. Pagination
 * is not session based hence Consumers SHOULD never assume repeatable results.
 * For example, a request for a list of 10 Resources beginning with a startIndex
 * of 1 may return different results when repeated as a Resource in the original
 * result could be deleted or new ones could be added in-between requests.
 * Pagination parameters and general behavior are derived from the OpenSearch
 * Protocol.
 * </p>
 * 
 * <p>
 * The following table describes the URL pagination parameters.
 * </p>
 * 
 * 
 * <table border="0" class="bodyTable table table-striped table-bordered table-hover">
 * <tr>
 * <th>Parameter</th>
 * <th>Description</th>
 * <th>Default</th>
 * </tr>
 * 
 * <tr>
 * <td>startIndex</td>
 * <td>The 1-based index of the first search result.</td>
 * <td>1</td>
 * </tr>
 * <td>count</td>
 * <td>Non-negative Integer. Specifies the desired maximum number of search
 * results per page; e.g., 10.</td>
 * <td>None. When specified the Service Provider MUST not return more results
 * than specified though MAY return fewer results. If unspecified, the maximum
 * number of results is set by the Service Provider.</td> </tr>
 * </table>
 * 
 * <h3>Sorting</h3>
 * 
 * <p>
 * Sort is OPTIONAL. Sorting allows Consumers to specify the order in which
 * Resources are returned by specifying a combination of sortBy and sortOrder
 * URL parameters.
 * </p>
 * 
 * <ul>
 * <li><b>sortBy: </b> The sortBy parameter specifies the attribute whose value
 * SHALL be used to order the returned responses. If the sortBy attribute
 * corresponds to a Singular Attribute, Resources are sorted according to that
 * attribute's value; if it's a Multi-valued Attribute, Resources are sorted by
 * the value of the primary attribute, if any, or else the first value in the
 * list, if any. If the attribute is complex the attribute name must be a path
 * to a Sub-Attribute in standard attribute notation ; e.g.,
 * sortBy=name.givenName. For all attribute types, if there is no data for the
 * specified sortBy value they are sorted via the 'sortOrder' parameter; i.e.,
 * they are ordered last if ascending and first if descending.</li>
 * <li><b>sortOrder: </b> The order in which the sortBy parameter is applied.
 * Allowed values are "ascending" and "descending". If a value for sortBy is
 * provided and no sortOrder is specified, the sortOrder SHALL default to
 * ascending. String type attributes are case insensitive by default unless the
 * attribute type is defined as a caseExact string. sortOrder MUST sort
 * according to the attribute type; i.e., for caseIgnore attributes, sort the
 * result using case insensitive, Unicode alphabetic sort order, with no
 * specific locale implied and for caseExact attribute types, sort the result
 * using case sensitive, Unicode alphabetic sort order.</li>
 * </ul>
 * 
 * <h3>Filtering</h3>
 * 
 * <p>
 * Refer to the Filter Element Description
 * </p>
 * 
 */
public abstract class DummyRestEndpoint<T extends Resource> implements ReadWriteEndpoint<T> {

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
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	@TypeHint(value = Response.class)
	public javax.ws.rs.core.Response post(@TypeHint(Resource.class) T resource) {
		validate(resource);

		Response<T> response = new Response<T>();
		Resource res = mock();
		response.setResource(res);
		System.out.println(res);
		return toResponse(CREATED, response, res.getMeta());
	}

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
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	@TypeHint(value = Response.class)
	@GET
	public javax.ws.rs.core.Response get(@PathParam("id") String id) {
		Response<T> response = new Response<T>();
		Resource resource = mock();
		response.setResource(resource);
		return toResponse(OK, response, resource.getMeta());
	}

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
	@Override
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@TypeHint(value = Response.class)
	@Path("")
	public javax.ws.rs.core.Response list(@QueryParam("attributes") List<String> attributes,
			@QueryParam("filter") Filter filter, @QueryParam("sortBy") String sortBy,
			@QueryParam("sortOrder") String sortOrder, @QueryParam("startIndex") Integer startIndex,
			@QueryParam("count") Integer count) {

		Response<T> response = new Response<T>();
		T res = mock();
		List<T> resources = new ArrayList<T>();
		resources.add(res);
		response.setResources(resources);
		return toResponse(OK, response, res.getMeta());
	}

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
	@Override
	@PATCH
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	@TypeHint(value = Response.class)
	public javax.ws.rs.core.Response patch(@TypeHint(Resource.class) Resource resource, @PathParam("id") String id) {
		Response<T> response = new Response<T>();
		Resource res = mock();

		response.setResource(res);
		return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.OK).entity(response).build();
	}

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
	@Override
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	@TypeHint(value = Response.class)
	public javax.ws.rs.core.Response put(@TypeHint(Resource.class) T resource, @PathParam("id") String id) {
		validate(resource);
		resource.setId(id);

		Response<T> response = new Response<T>();
		Resource res = mock(resource);
		response.setResource(res);
		return toResponse(OK, response, res.getMeta());
	}

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
	@Override
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response delete(@PathParam("id") String id, @Context HttpServletRequest request) {
		return javax.ws.rs.core.Response.status(OK).build();
	}

	private javax.ws.rs.core.Response toResponse(Status status, Response<T> response, Meta meta) {
		return javax.ws.rs.core.Response.status(status).entity(response)
				.tag(meta.getVersion().substring(1, meta.getVersion().length() - 1))
				.location(URI.create(meta.getLocation())).build();
	}

	protected abstract void validate(T res);
	protected abstract T mock();
	
	protected abstract T mock(T resource);
}
