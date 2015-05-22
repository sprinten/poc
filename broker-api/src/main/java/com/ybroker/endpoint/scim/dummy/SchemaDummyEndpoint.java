package com.ybroker.endpoint.scim.dummy;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.enunciate.Facet;
import org.codehaus.enunciate.Facets;
import org.codehaus.enunciate.jaxrs.TypeHint;

import com.ybroker.model.api.Response;
import com.ybroker.model.core.base.Schema;
import com.ybroker.model.core.base.Schema.SchemaAttribute;

/**
 * <p>
 * Retrieve a Resource's Schema. The Resource schema specifies the Attribute(s)
 * and meta-data that constitute a Resource. Supports only GET
 * </p>
 */
@Path("/Schemas")
@Facets({ @Facet(name = "custom", value = "Schemas", documentation = "Retrieve a Resource's Schema. The Resource schema specifies the Attribute(s) and meta-data that constitute a Resource.") })
public class SchemaDummyEndpoint {

	/**
	 * Retrieve the Users Schema
	 * 
	 * @return The Users Schema
	 */
	@GET
	@Path("/Users")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@TypeHint(Schema.class)
	public javax.ws.rs.core.Response getUsers() {
		Response<Schema> response = new Response<Schema>();
		Schema schema = new Schema();
		schema.setId("urn:scim:schemas:core:1.0:User");
		schema.setName("User");
		schema.setDescription("http://tools.ietf.org/html/draft-ietf-scim-core-schema-00#section-11.6");
		schema.setEndpoint("/Users");

		List<SchemaAttribute> attributes = new ArrayList<SchemaAttribute>();
		SchemaAttribute attribute = new SchemaAttribute();
		attribute.setCaseExact(false);
		attribute.setDescription("Unique identifier for the User resource");
		attribute.setMultiValued(false);
		attribute.setName("id");
		attribute.setReadOnly(true);
		attribute.setRequired(true);
		attribute.setSchema("urn:scim:schemas:core:1.0");
		attribute.setType("UUID");

		attributes.add(attribute);

		schema.setAttributes(attributes);
		response.setResource(schema);
		return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.OK).entity(response).build();
	}

	/**
	 * Retrieve the Groups Schema
	 * 
	 * @return The Groups Schema
	 */
	@GET
	@Path("/Groups")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@TypeHint(Schema.class)
	public javax.ws.rs.core.Response getGroups() {
		Response<Schema> response = new Response<Schema>();
		Schema schema = new Schema();
		schema.setId("urn:scim:schemas:core:1.0:Group");
		schema.setName("Group");
		schema.setEndpoint("/Groups");

		List<SchemaAttribute> attributes = new ArrayList<SchemaAttribute>();
		SchemaAttribute attribute = new SchemaAttribute();
		attribute.setCaseExact(false);
		attribute.setMultiValued(false);
		attribute.setName("displayName");
		attribute.setReadOnly(true);
		attribute.setRequired(true);
		attribute.setSchema("urn:scim:schemas:core:1.0");
		attribute.setType("String");

		attributes.add(attribute);

		schema.setAttributes(attributes);
		response.setResource(schema);
		return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.OK).entity(response).build();
	}
}
