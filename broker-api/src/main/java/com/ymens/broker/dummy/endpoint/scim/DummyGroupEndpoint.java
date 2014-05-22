package com.ymens.broker.dummy.endpoint.scim;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.enunciate.Facet;
import org.codehaus.enunciate.Facets;
import org.springframework.security.access.prepost.PreAuthorize;

import com.ymens.broker.api.model.scim.Group;

/**
 */
@Path("/Groups")
@Produces(MediaType.APPLICATION_JSON)
@PreAuthorize("hasRole('ROLE_DUMMY')")
@Facets({@Facet(name = "custom", value ="Groups")})
public class DummyGroupEndpoint extends DummyRestEndpoint<Group> {

	protected Group mock() {
		return new Group();
	}

	protected void validate(Group group) {
	}

	@Override
	protected Group mock(Group resource) {
		return mock();
	}
}
