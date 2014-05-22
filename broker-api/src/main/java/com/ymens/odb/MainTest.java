package com.ymens.odb;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;

public class MainTest {

	public static void main(String[] args) {
		
		
		
		// OPEN THE DATABASE
	    ODatabaseDocumentTx db = new ODatabaseDocumentTx("memory:scim").open("admin", "admin");

	    // CREATE A NEW DOCUMENT AND FILL IT
	    ODocument doc = new ODocument("Person");
	    doc.field( "name", "Luke" );
	    doc.field( "surname", "Skywalker" );
	    doc.field( "city", new ODocument("City").field("name","Rome").field("country", "Italy") );

	    // SAVE THE DOCUMENT
	    doc.save();

	    db.close();
	}

}
