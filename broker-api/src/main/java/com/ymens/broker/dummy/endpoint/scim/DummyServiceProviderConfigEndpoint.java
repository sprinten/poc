package com.ymens.broker.dummy.endpoint.scim;

import static javax.ws.rs.core.Response.Status.OK;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.enunciate.Facet;
import org.codehaus.enunciate.Facets;
import org.codehaus.enunciate.jaxrs.TypeHint;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.ymens.broker.api.endpoint.generic.ReadonlyEndpoint;
import com.ymens.broker.api.model.generic.Response;
import com.ymens.broker.api.model.scim.ServiceProviderConfig;

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
public class DummyServiceProviderConfigEndpoint implements ReadonlyEndpoint<ServiceProviderConfig> {

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
		ServiceProviderConfig config = new ServiceProviderConfig();

		ODatabaseDocumentTx db = new ODatabaseDocumentTx("memory:scim").open("admin", "admin");
		List<ODocument> result = db.query(new OSQLSynchQuery<ODocument>("select * from "
				+ ServiceProviderConfig.class.getSimpleName()));

		ODocument spConfigDoc = result.get(0);

		
		
		return javax.ws.rs.core.Response.status(OK).entity(response).build();
	}
}
