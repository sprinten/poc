package com.ymens.odb;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;
import com.orientechnologies.orient.object.iterator.OObjectIteratorClass;
import com.orientechnologies.orient.server.OServer;
import com.orientechnologies.orient.server.OServerMain;
import com.ymens.broker.api.model.scim.ServiceProviderConfig;
import com.ymens.broker.api.model.scim.ServiceProviderConfig.AuthenticationScheme;

public class DatabaseStart {

	public static OServer server;

	public static void main(String[] args) throws Exception {
		server = OServerMain.create();
		server.startup(DatabaseStart.class.getResourceAsStream("/orientdb-server-config.xml"));
		server.activate();

		OObjectDatabaseTx db = new OObjectDatabaseTx("memory:scim");
		db.create();
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

		
		System.out.println("\n spConfig=" + spConfig.toString());
		
		Object save = db.save(spConfig);
		
		System.out.println("\n newInstance=" + new ServiceProviderConfig());
		
		((ServiceProviderConfig)save).setId(UUID.randomUUID().toString());
		
		JSONObject object = new JSONObject(save);
		
		System.out.println(object);
		
//		System.out.println(new Gson().toJson((ServiceProviderConfig)save));
		System.out.println(db.countClass(ServiceProviderConfig.class));
		
		
		OObjectIteratorClass<ServiceProviderConfig> browseClass = db.browseClass(ServiceProviderConfig.class);
		
		

		ServiceProviderConfig next = browseClass.next();
		
		System.out.println("\n newInstance=" + next.toString());

		db.close();

		server.shutdown();
	}
}
