package com.ymens.broker.odb;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.orientechnologies.orient.core.db.document.ODatabaseDocument;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentPool;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.server.OServer;
import com.orientechnologies.orient.server.OServerMain;
import com.ymens.odb.DatabaseStart;

public class DatabaseFilter implements Filter {

	public enum Type {

		/**
		 * Define in memory DB for testing purposes.
		 */
		MEMORY,

		/**
		 * Define in memory for PoC implementation.
		 */
		PLOCAL,

		/**
		 * Define remote DB for real-life scenarios.
		 */
		REMOTE;
	}

	private Type type = Type.MEMORY;

	private String name = null;

	private String path = "";

	private String dbUrl = "";

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
		ODatabaseDocument database = ODatabaseDocumentPool.global().acquire(dbUrl, "admin", "admin");
		try {
			chain.doFilter(request, response);
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		} finally {
			database.close();
		}
	}

	public void destroy() {
		ODatabaseDocumentPool.global().close();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Init DB filter");
		type = Type.valueOf(filterConfig.getInitParameter("type"));

		name = filterConfig.getInitParameter("name");

		if (!Type.MEMORY.equals(type)) {
			path = filterConfig.getInitParameter("path");
		}

		dbUrl = type + ":" + path + name;

		try {
			OServer server = OServerMain.create();
			server.startup(DatabaseStart.class.getResourceAsStream("/orientdb-server-config.xml"));
			server.activate();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException
				| SecurityException | InvocationTargetException | NoSuchMethodException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		ODatabaseDocumentTx db = new ODatabaseDocumentTx(dbUrl);

		if (!db.exists()) {
			db.create();
		}

		db.open("admin", "admin");
	}
}
