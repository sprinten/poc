package com.ymens.broker.dummy.endpoint.scim;

import java.util.HashMap;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.GenericXmlContextLoader;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import com.ymens.broker.api.model.scim.User;
import com.ymens.broker.provider.ApiOriginFilter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = GenericXmlContextLoader.class, value = { "classpath:/security.xml" })
public class DummyUserEndpointTest extends JerseyTest {

	private static final String RESOURCE = "Users";

	private static final AppDescriptor APP_DESCRIPTOR = new WebAppDescriptor.Builder("com.ymens.broker").addFilter(
			ApiOriginFilter.class, "f").build();

	public DummyUserEndpointTest() {
		super(APP_DESCRIPTOR);
	}

	@Test
	public void testRegisterAndUpdateUserRawJson() throws Exception {
		long nanoTime = System.nanoTime();
		String password = "pa$$word8888889!1234567890";

		String requestEntity = "{ \"schemas\":[\"urn:scim:schemas:core:1.0\", \"urn:scim:schemas:extension:enterprise:1.0\"], "
				+ "\"userName\":\"S"
				+ nanoTime
				+ "\","
				+ "\"displayName\":\"D"
				+ nanoTime
				+ "\","
				+ "\"preferredLanguage\":\"en_FI\","
				+ "\"password\":\""
				+ password
				+ "\","
				+ "\"name\":{"
				+ "\"familyName\":\"Jensen\","
				+ "\"givenName\":\"Barbara\" }"
				+ ","
				+ "\"emails\": ["
				+ "{"
				+ "\"value\": \"S"
				+ nanoTime
				+ "@example.com\","
				+ "\"primary\": true"
				+ "},"
				+ "{"
				+ "\"value\": \"C"
				+ nanoTime
				+ "@example.com\","
				+ "\"primary\": false"
				+ "}]"
				+ ",\"addresses\": [{\"country\": \"FI\", \"primary\": \"true\"},{\"country\": \"SE\", \"primary\": \"false\"}]"
				+ "}";

		ClientResponse response = resource()
				.path(RESOURCE)
				.header("Authorization",
						"Basic bN9B2rMAtWG7xC/pYcEj9bYk9Iu2F1yiw0OSj+lLOK60bzuNWiukRD6gAKR1c6SRVRJFvOQVJ4FfhFYf8k0vqg265TWLR9ttZHZwhC4AyekFH0Bot3icpTC9SPdtVIULOcJPwLcyE89OpqSv31q2Ccdlxq1B70p5woqFeZHhwEw=")
				.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, requestEntity);

		String responseContent = response.getEntity(String.class);

		System.out.println(response.getHeaders());

		System.out.println(response.hasEntity());

		System.out.println(responseContent);

		Assert.assertEquals(201, response.getStatus());
		String id = extractValue(responseContent, "id");

		response = resource()
				.path(RESOURCE + "/" + id)
				.header("Authorization",
						"Basic bN9B2rMAtWG7xC/pYcEj9bYk9Iu2F1yiw0OSj+lLOK60bzuNWiukRD6gAKR1c6SRVRJFvOQVJ4FfhFYf8k0vqg265TWLR9ttZHZwhC4AyekFH0Bot3icpTC9SPdtVIULOcJPwLcyE89OpqSv31q2Ccdlxq1B70p5woqFeZHhwEw=")
				.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		Assert.assertEquals(200, response.getStatus());
		responseContent = response.getEntity(String.class);

		HashMap<String, String> values = new HashMap<String, String>();
		values.put("displayName", "Aladin");
		responseContent = substituteValues(values, responseContent);

		response = resource()
				.path(RESOURCE + "/" + id)
				.header("Authorization",
						"Basic bN9B2rMAtWG7xC/pYcEj9bYk9Iu2F1yiw0OSj+lLOK60bzuNWiukRD6gAKR1c6SRVRJFvOQVJ4FfhFYf8k0vqg265TWLR9ttZHZwhC4AyekFH0Bot3icpTC9SPdtVIULOcJPwLcyE89OpqSv31q2Ccdlxq1B70p5woqFeZHhwEw=")
				.header(HttpHeaders.IF_MATCH, response.getEntityTag()).type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).put(ClientResponse.class, responseContent);

		Assert.assertEquals(200, response.getStatus());
		User responseUser = response.getEntity(User.class);
		Assert.assertEquals("Aladin", responseUser.getDisplayName());
	}

	@Test
	public void testRegisterUserRawXML2() throws Exception {
		long nanoTime = System.nanoTime();

		String input = "<SCIM xmlns=\"urn:scim:schemas:core:1.0\" "
				+ "xmlns:enterprise=\"urn:scim:schemas:extension:enterprise:1.0\">" + "<userName>S"
				+ nanoTime
				+ "</userName>"
				+ "<preferredLanguage>en_US</preferredLanguage>"
				+ "<name>"
				+ "<givenName>Keimo</givenName>"
				+ "</name>"
				+ "<password>foobar</password>"
				+ "<emails>"
				+ "<email>"
				+ "<value>S"
				+ nanoTime
				+ "@test.com</value>"
				+ "<primary>true</primary>"
				+ "</email>"
				+ "</emails>"
				+ "<phoneNumbers>"
				+ "<phoneNumber>"
				+ "<value>+"
				+ nanoTime
				+ "</value>"
				+ "<primary>true</primary>"
				+ "</phoneNumber>"
				+ "</phoneNumbers>"
				+ "<addresses><address><country>FI</country></address></addresses>"
				+ "<enterprise:gender>male</enterprise:gender>" + "</SCIM>";

		ClientResponse cr = resource()
				.path(RESOURCE)
				.header("Authorization",
						"Basic bN9B2rMAtWG7xC/pYcEj9bYk9Iu2F1yiw0OSj+lLOK60bzuNWiukRD6gAKR1c6SRVRJFvOQVJ4FfhFYf8k0vqg265TWLR9ttZHZwhC4AyekFH0Bot3icpTC9SPdtVIULOcJPwLcyE89OpqSv31q2Ccdlxq1B70p5woqFeZHhwEw=")
				.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);

		// String responseContent = cr.getEntity(String.class);
		// System.out.println(responseContent);
		Assert.assertEquals(201, cr.getStatus());
	}

	@Test
	public void testRegisterUserReservedUsername() throws Exception {
		String input = "{ \"schemas\":[\"urn:scim:schemas:core:1.0\"], " + "\"userName\":\"existing\","
				+ "\"preferredLanguage\":\"en_US\"," + "\"name\":{" + "\"familyName\":\"Jensen\","
				+ "\"givenName\":\"Barbara\"}," + "\"password\":\"foobar\"" + "," + "\"emails\": [" + "{"
				+ "\"value\": \"bjensen@example.com\"," + "\"primary\": true" + "}," + "{"
				+ "\"value\": \"bjensen2@example.com\"," + "\"primary\": false" + "}]"
				+ ",\"addresses\": [{\"country\": \"FI\"}]" + "}";
		ClientResponse responseMsg = resource()
				.path(RESOURCE)
				.header("Authorization",
						"Basic bN9B2rMAtWG7xC/pYcEj9bYk9Iu2F1yiw0OSj+lLOK60bzuNWiukRD6gAKR1c6SRVRJFvOQVJ4FfhFYf8k0vqg265TWLR9ttZHZwhC4AyekFH0Bot3icpTC9SPdtVIULOcJPwLcyE89OpqSv31q2Ccdlxq1B70p5woqFeZHhwEw=")
				.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);
		// String responseContent = responseMsg.getEntity(String.class);
		// System.out.println(responseContent);
		Assert.assertEquals(409, responseMsg.getStatus());
	}

	@Test
	public void testRegisterUserWithGender() throws Exception {
		long nanoTime = System.nanoTime();
		String input = "{ \"schemas\":[\"urn:scim:schemas:core:1.0\"], " + "\"userName\":\"W" + nanoTime + "\","
				+ "\"preferredLanguage\":\"en_US\"," + "\"name\":{" + "\"familyName\":\"Jensen\","
				+ "\"givenName\":\"Barbara\"}," + "\"password\":\"foobar\"" + "," + "\"emails\": [" + "{"
				+ "\"value\": \"W" + nanoTime + "@example.com\"," + "\"primary\": true" + "}," + "{" + "\"value\": \""
				+ nanoTime + "2@example.com\"," + "\"primary\": false" + "}]"
				+ ",\"addresses\": [{\"country\": \"FI\"}]," + "\"gender\":\"female\"" + "}";

		ClientResponse responseMsg = resource()
				.path(RESOURCE)
				.header("Authorization",
						"Basic bN9B2rMAtWG7xC/pYcEj9bYk9Iu2F1yiw0OSj+lLOK60bzuNWiukRD6gAKR1c6SRVRJFvOQVJ4FfhFYf8k0vqg265TWLR9ttZHZwhC4AyekFH0Bot3icpTC9SPdtVIULOcJPwLcyE89OpqSv31q2Ccdlxq1B70p5woqFeZHhwEw=")
				.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);
		// String responseContent = responseMsg.getEntity(String.class);
		// System.out.println(responseContent);
		Assert.assertEquals(201, responseMsg.getStatus());
	}

	@Test
	public void testRegisterUserReservedEmail() throws Exception {
		long nanoTime = System.nanoTime();

		String input = "{ \"schemas\":[\"urn:scim:schemas:core:1.0\"], " + "\"userName\":\"S" + nanoTime + "\","
				+ "\"preferredLanguage\":\"en_GB\"," + "\"name\":{" + "\"familyName\":\"Jensen\","
				+ "\"givenName\":\"Barbara\"}," + "\"password\":\"foobar\"" + "," + "\"emails\": [" + "{"
				+ "\"value\": \"reserved@noksu.com\"," + "\"primary\": true" + "}" + "]"
				+ ",\"addresses\": [{\"country\": \"FI\"}]" + "}";

		ClientResponse responseMsg = resource()
				.path(RESOURCE)
				.header("Authorization",
						"Basic bN9B2rMAtWG7xC/pYcEj9bYk9Iu2F1yiw0OSj+lLOK60bzuNWiukRD6gAKR1c6SRVRJFvOQVJ4FfhFYf8k0vqg265TWLR9ttZHZwhC4AyekFH0Bot3icpTC9SPdtVIULOcJPwLcyE89OpqSv31q2Ccdlxq1B70p5woqFeZHhwEw=")
				.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);

		Assert.assertEquals(409, responseMsg.getStatus());
	}

	@Test
	public void testInvalidInput() throws Exception {
		String username = "" + System.currentTimeMillis();

		String input = "<SCIM xmlns=\"urn:scim:schemas:core:1.0\">" + "<userName>" + username + "</userName>"
				+ "<preferredLanguage>en_FI</preferredLanguage>" + "<password>123456</password>" + "<emails>"
				+ "<email>" + "<value>" + username + "@test.com</value>" + "<primary>true</primary>" + "</email>"
				+ "</emails>" + "<addresses><address><country>FI</country></address></addresses>" + "</XXX>>";

		ClientResponse cr = resource()
				.path(RESOURCE)
				.header("Authorization",
						"Basic bN9B2rMAtWG7xC/pYcEj9bYk9Iu2F1yiw0OSj+lLOK60bzuNWiukRD6gAKR1c6SRVRJFvOQVJ4FfhFYf8k0vqg265TWLR9ttZHZwhC4AyekFH0Bot3icpTC9SPdtVIULOcJPwLcyE89OpqSv31q2Ccdlxq1B70p5woqFeZHhwEw=")
				.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);

		String response = cr.getEntity(String.class);

		Assert.assertEquals("Http status code 400 expected.", 400, cr.getStatus());
		Assert.assertTrue("Expexted string from response not found.",
				response.indexOf("Invalid, syntactically incorrect or unparseable input provided") > 1);
		Assert.assertTrue("Expexted string from response not found.",
				response.indexOf("urn:eugene.zhukov:scim:errors:1.0:input:invalid") > 1);
	}

	@Test
	public void testDelete() throws Exception {
		long timestamp = System.currentTimeMillis();
		String password = "pa$$word8888889!";

		String input = "<User xmlns=\"urn:scim:schemas:core:1.0\" "
				+ "xmlns:enterprise=\"urn:scim:schemas:extension:enterprise:1.0\">" + "<userName>"
				+ timestamp
				+ "</userName>"
				+ "<preferredLanguage>en_GB</preferredLanguage>"
				+ "<password>"
				+ password
				+ "</password>"
				+ "<emails>"
				+ "<email>"
				+ "<value>"
				+ timestamp
				+ "@test.com</value>"
				+ "<primary>true</primary>"
				+ "</email>"
				+ "<email>"
				+ "<value>"
				+ timestamp
				+ "2@test.com</value>"
				+
				// "<primary>false</primary>" +
				"</email>"
				+ "</emails>"
				+ "<addresses><address><country>FI</country></address></addresses>"
				+ "<enterprise:gender>female</enterprise:gender>" + "</User>";

		ClientResponse cr = resource()
				.path(RESOURCE)
				.header("Authorization",
						"Basic bN9B2rMAtWG7xC/pYcEj9bYk9Iu2F1yiw0OSj+lLOK60bzuNWiukRD6gAKR1c6SRVRJFvOQVJ4FfhFYf8k0vqg265TWLR9ttZHZwhC4AyekFH0Bot3icpTC9SPdtVIULOcJPwLcyE89OpqSv31q2Ccdlxq1B70p5woqFeZHhwEw=")
				.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);

		String response = cr.getEntity(String.class);
		// System.out.println(response);
		Assert.assertEquals("Http status code 201 expected.", 201, cr.getStatus());
		Assert.assertTrue("Expected string from response not found.",
				response.indexOf("<userName>" + timestamp + "</userName>") > 1);

		cr = resource()
				.path(RESOURCE + "/" + extractValue(response, "id"))
				.header("Authorization",
						"Basic bN9B2rMAtWG7xC/pYcEj9bYk9Iu2F1yiw0OSj+lLOK60bzuNWiukRD6gAKR1c6SRVRJFvOQVJ4FfhFYf8k0vqg265TWLR9ttZHZwhC4AyekFH0Bot3icpTC9SPdtVIULOcJPwLcyE89OpqSv31q2Ccdlxq1B70p5woqFeZHhwEw=")
				.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);

		Assert.assertEquals("Http status code 200 expected.", 200, cr.getStatus());
	}

	// @Test
	public void testRegisterUserRawTwoPrimaryAddresses() {
		String username = "" + System.currentTimeMillis();

		String input = "<SCIM xmlns=\"urn:scim:schemas:core:1.0\">"
				+ "<userName>"
				+ username
				+ "</userName>"
				+ "<preferredLanguage>en_SE</preferredLanguage>"
				+ "<password>123456</password>"
				+ "<emails>"
				+ "<email>"
				+ "<value>"
				+ username
				+ "@test.com</value>"
				+ "<primary>true</primary>"
				+ "</email>"
				+ "</emails>"
				+ "<addresses><address><country>FI</country><primary>true</primary></address><address><country>SE</country><primary>true</primary></address></addresses>"
				+ "</SCIM>";

		ClientResponse cr = resource()
				.path(RESOURCE)
				.header("Authorization",
						"Bearer Mnxabms6rYiy+mb1uOzeMjSuf0hhzYvWeZKjsaqMh+A6SkP5oOH5neORSkQOXsbXOZFfwT6v9UM6sltOWWYT6umfGvrsKJHLMtTzSMs5GrAfeai/ilNYrjgd49QV0QJrimQXsdCkcJqNNCm8eyVP5W7GD+jMk6CVN1mvExngAVk=")
				.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);

		String response = cr.getEntity(String.class);
		Assert.assertEquals("Http status code 400 expected.", 400, cr.getStatus());
		Assert.assertTrue("Expexted string from response not found.",
				response.indexOf("Multiple primary addresses provided.") > 1);
	}

	// @Test
	public void testRegisterUserError() {
		long nanoTime = System.nanoTime();
		String input = "{ \"schemas\":[\"urn:scim:schemas:core:1.0\"], "
				+ "\"userName\":\"S"
				+ nanoTime
				+ "\","
				+ "\"preferredLanguage\":\"en_SE\","
				+ "\"password\":\"123456\","
				+ "\"name\":{"
				+ "\"familyName\":\"Jensen\","
				+ "\"givenName\":\"Barbara\" }"
				+ ","
				+ "\"phoneNumbers\": [ { \"value\": \"555-555-5555\", \"type\": \"work\" }, { \"value\": \"555-555-4444\", \"primary\": \"true\" } ]"
				+ ",\"addresses\":[{\"country\":\"FI\"}]" + "}";

		ClientResponse responseMsg = resource()
				.path(RESOURCE)
				.header("Authorization",
						"Bearer Mnxabms6rYiy+mb1uOzeMjSuf0hhzYvWeZKjsaqMh+A6SkP5oOH5neORSkQOXsbXOZFfwT6v9UM6sltOWWYT6umfGvrsKJHLMtTzSMs5GrAfeai/ilNYrjgd49QV0QJrimQXsdCkcJqNNCm8eyVP5W7GD+jMk6CVN1mvExngAVk=")
				.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);

		String expected = "{\"Errors\":[{\"description\":\"555-555-5555Providedmobilenumberisinvalid.\",\"code\":\"400\","
				+ "\"uri\":\"urn:info:scim:errors:1.0:phoneNumbers:phoneNumber:invalid\"},"
				+ "{\"description\":\"555-555-4444Providedmobilenumberisinvalid.\",\"code\":\"400\","
				+ "\"uri\":\"urn:info:scim:errors:1.0:phoneNumbers:phoneNumber:invalid\"}]}";

		Assert.assertEquals("Http status code 400 expected.", 400, responseMsg.getStatus());

		String response = responseMsg.getEntity(String.class);

		Assert.assertEquals("Expexted string from response not found.", expected, response.replaceAll("\n", "")
				.replaceAll(" ", ""));
	}

	private static String extractValue(String row, String attr) {

		if (row.indexOf(attr) < 0) {
			return null;
		}

		int start = row.indexOf(attr) + attr.length() + 1;
		int end = row.indexOf("</" + attr);

		if (end < 0) {
			return null;
		}
		return row.substring(start, end);
	}

	private static String substituteValues(HashMap<String, String> valuesIn, String xml) {

		if (valuesIn == null) {
			return xml;
		}

		for (String attr : valuesIn.keySet()) {

			if (xml.contains("</" + attr + ">")) {
				xml = xml.replace(extractValue(xml, attr), valuesIn.get(attr));
			}
		}
		return xml;
	}
}