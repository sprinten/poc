package com.ymens.broker.dummy.endpoint.scim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.GenericXmlContextLoader;

import com.orientechnologies.orient.object.db.OObjectDatabaseTx;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import com.ymens.broker.api.model.scim.ServiceProviderConfig;
import com.ymens.broker.api.model.scim.ServiceProviderConfig.AuthenticationScheme;
import com.ymens.broker.odb.DatabaseFilter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = GenericXmlContextLoader.class, value = { "classpath:/security.xml" })
public class DummyServiceProviderConfigEndpointTest extends JerseyTest {

	public DummyServiceProviderConfigEndpointTest() {
		super();

	}

	@Override
	protected AppDescriptor configure() {
		Map<String, String> initParams = new HashMap<String, String>();

		initParams.put("type", DatabaseFilter.Type.MEMORY.toString());
		initParams.put("name", "scim");

		AppDescriptor appDescriptor = new WebAppDescriptor.Builder("com.ymens.broker").addFilter(DatabaseFilter.class,
				"memoryDbFilter", initParams).build();
		return appDescriptor;
	}

	@Before
	public void setup() {
		OObjectDatabaseTx db = new OObjectDatabaseTx("memory:scim");
		db.open("admin", "admin");
		db.getEntityManager().registerEntityClasses("com.ymens.broker.api.model");

		ServiceProviderConfig spConfig = new ServiceProviderConfig();
		spConfig.setDocumentationUrl("http://ee.dy.fi/scim");

		List<AuthenticationScheme> authenticationSchemes = new ArrayList<AuthenticationScheme>();
		AuthenticationScheme authenticationScheme = new AuthenticationScheme();
		authenticationScheme.setDescription("Authentication Scheme using the Http Basic Standard");
		authenticationScheme.setDocumentationUrl("http://help.ymens.com/httpBasic.html");
		authenticationScheme.setName("HTTP Basic");
		authenticationScheme.setSpecUrl("http://www.ietf.org/rfc/rfc2617.txt");
		authenticationSchemes.add(authenticationScheme);
		spConfig.setAuthenticationSchemes(authenticationSchemes);

		ServiceProviderConfig.Bulk bulk = new ServiceProviderConfig.Bulk();
		bulk.setSupported(false);
		spConfig.setBulk(bulk);

		ServiceProviderConfig.ChangePassword changePassword = new ServiceProviderConfig.ChangePassword();
		changePassword.setSupported(true);
		spConfig.setChangePassword(changePassword);

		ServiceProviderConfig.Etag etag = new ServiceProviderConfig.Etag();
		etag.setSupported(true);
		spConfig.setEtag(etag);

		ServiceProviderConfig.Filter filter = new ServiceProviderConfig.Filter();
		filter.setSupported(false);
		spConfig.setFilter(filter);

		ServiceProviderConfig.Patch patch = new ServiceProviderConfig.Patch();
		patch.setSupported(false);
		spConfig.setPatch(patch);

		ServiceProviderConfig.Sort sort = new ServiceProviderConfig.Sort();
		sort.setSupported(false);
		spConfig.setSort(sort);

		ServiceProviderConfig.XmlDataFormat xmlDataFormat = new ServiceProviderConfig.XmlDataFormat();
		xmlDataFormat.setSupported(true);
		spConfig.setXmlDataFormat(xmlDataFormat);

		db.save(spConfig);
	}

	@Test
	public void testServiceProviderConfiguration() {
		ClientResponse cr = resource()
				.path("ServiceProviderConfigs")
				.header("Authorization",
						"Basic bN9B2rMAtWG7xC/pYcEj9bYk9Iu2F1yiw0OSj+lLOK60bzuNWiukRD6gAKR1c6SRVRJFvOQVJ4FfhFYf8k0vqg265TWLR9ttZHZwhC4AyekFH0Bot3icpTC9SPdtVIULOcJPwLcyE89OpqSv31q2Ccdlxq1B70p5woqFeZHhwEw=")
				.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		Assert.assertEquals("Http status code 200 expected.", 200, cr.getStatus());

		System.out.println(cr.getHeaders());

		System.out.println(cr.hasEntity());

		System.out.println(cr.getEntity(ServiceProviderConfig.class));
	}
}
