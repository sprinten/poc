package com.ybroker.endpoint.scim.dummy;

import java.util.UUID;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.enunciate.Facet;
import org.codehaus.enunciate.Facets;
import org.springframework.security.access.prepost.PreAuthorize;

import com.ybroker.model.core.User;
import com.ybroker.model.core.base.Meta;
import com.ybroker.model.core.contact.Name;

/**
 */
@Path("/Users")
@Produces(MediaType.APPLICATION_JSON)
@PreAuthorize("hasRole('ROLE_DUMMY')")
@Facets({ @Facet(name = "custom", value = "Users") })
public class DummyUserEndpoint extends DummyRestEndpoint<User> {

	protected User mock() {
		User user = new User();
		user.setId(new UUID(78317, 9839183).toString());
		user.setDisplayName("Vlad Mihnea");
		Name name = new Name();
		name.setFamilyName("Mihnea");
		user.setName(name);
		Meta value = new Meta();
		value.setVersion("1.0");
		value.setLocation("http://broker.ymens.com/api");
		user.setMeta(value);
		return user;
	}

	protected void validate(User user) {

	}

	@Override
	protected User mock(User resource) {
		User response = mock();
		response.setDisplayName(resource.getDisplayName());
		return response;
	}

}
