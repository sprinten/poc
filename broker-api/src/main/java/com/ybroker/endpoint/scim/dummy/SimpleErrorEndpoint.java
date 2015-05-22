package com.ybroker.endpoint.scim.dummy;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.enunciate.Facet;
import org.codehaus.enunciate.Facets;
import org.codehaus.enunciate.jaxrs.TypeHint;

import com.ybroker.model.api.Error;
import com.ybroker.model.core.base.Resource;
import com.ybroker.provider.RestException;

@Path("/Errors")
@Produces(MediaType.APPLICATION_JSON)
@Facets({ @Facet(name = "custom", value = "Errors", documentation = "Endpoint for redirection in case of errors") })
public class SimpleErrorEndpoint {

	/**
	 * Retrieve the list of errors.
	 * 
	 * @param request The invalid request
	 * @return The list of errors.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.WILDCARD })
	@TypeHint(Error.class)
	public Response get(@TypeHint(Resource.class) @Context HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if (statusCode == HttpServletResponse.SC_UNAUTHORIZED) {
			return RestException.constructUnauthorized();
		}
		return RestException.constructErrorResponse(statusCode);
	}

	/**
	 * Retrieve the list of errors in care of redirect.
	 * 
	 * @param request The invalid request
	 * 
	 * @return The list of errors.
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.WILDCARD })
	@TypeHint(value = Error.class)
	public Response post(@TypeHint(Resource.class) @Context HttpServletRequest request) {
		return get(request);
	}
}
