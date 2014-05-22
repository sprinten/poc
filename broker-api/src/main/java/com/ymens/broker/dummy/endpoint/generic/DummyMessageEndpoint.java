package com.ymens.broker.dummy.endpoint.generic;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.enunciate.Facet;
import org.codehaus.enunciate.Facets;
import org.codehaus.enunciate.jaxrs.TypeHint;

import com.ymens.broker.api.endpoint.generic.ReadonlyEndpoint;
import com.ymens.broker.api.model.generic.Message;

/**
 * Message Resource.
 */
@Path("/Messages")
@Produces(MediaType.APPLICATION_JSON)
@Resource(name = "Messages", description = "Message Resource")
@Facets({@Facet(name = "custom", value ="Messages")})
public class DummyMessageEndpoint implements ReadonlyEndpoint<Message> {

	/**
	 * Will poll the first message from the queue.
	 * 
	 * @return The message details
	 */
	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@TypeHint(Message.class)
	public javax.ws.rs.core.Response get() {
		return null;
	}
}
