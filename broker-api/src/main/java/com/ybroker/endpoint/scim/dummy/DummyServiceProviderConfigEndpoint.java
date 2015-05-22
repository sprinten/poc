package com.ybroker.endpoint.scim.dummy;

import static javax.ws.rs.core.Response.Status.OK;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.enunciate.Facet;
import org.codehaus.enunciate.Facets;
import org.codehaus.enunciate.jaxrs.TypeHint;

import com.ybroker.endpoint.generic.ReadonlyEndpoint;
import com.ybroker.model.api.Response;
import com.ybroker.model.scim.config.ServiceProviderConfig;

/**
 * <p>
 * The Service Provider Configuration Resource enables a Service Provider to
 * expose its compliance with the SCIM specification in a standardized form as
 * well as provide additional implementation details to Consumers. All
 * attributes are READ-ONLY. Only support GET.
 * </p>
 * 
 */
@Facets({ @Facet(name = "custom", value = "Provider Config", documentation = "The Service Provider Configuration Resource enables a Provider to expose its compliance with the specification in a standardized form as well as provide additional implementation details to Consumers.") })
@Path("/ServiceProviderConfigs")
public class DummyServiceProviderConfigEndpoint implements
		ReadonlyEndpoint<ServiceProviderConfig> {

	/**
	 * Retrieve the Service Provider's Configuration
	 * 
	 * @return The Configuration
	 */
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@TypeHint(value = ServiceProviderConfig.class)
	public javax.ws.rs.core.Response get() {
		Response<ServiceProviderConfig> response = new Response<ServiceProviderConfig>();
		return javax.ws.rs.core.Response.status(OK).entity(response).build();
	}
}
