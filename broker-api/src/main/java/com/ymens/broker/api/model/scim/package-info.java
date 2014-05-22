@XmlSchema(namespace = "http://api.ymens.com/model/scim")
@org.codehaus.enunciate.json.JsonSchema(schemaId = "SCIM-Model")
package com.ymens.broker.api.model.scim;

/**
 * <p>Schema for Cross-Domain Identity Management</p>
 * 
 * <p>While there are existing standards for describing and exchanging user information, many of these standards can be difficult to implement and/or use; e.g., their wire protocols do not easily traverse firewalls and/or are not easily layered onto existing web protocols. 
 * As a result, many cloud providers implement non-standard APIs for managing users within their services. 
 * This increases both the cost and complexity associated with organizations adopting products and services from multiple cloud providers as they must perform redundant integration development. 
 * Similarly, cloud services providers seeking to interoperate with multiple application marketplaces or cloud identity providers must be redundantly integrated.</p>
 * 
 * <p>SCIM seeks to simplify this problem through a simple to implement specification suite that provides a common user schema and extension model, as well as binding documents to provide patterns for exchanging this schema via a REST API. 
 * It draws inspiration and best practice, building upon existing user APIs and schemas from a wide variety of sources including, but not limited to, existing APIs exposed by cloud providers, PortableContacts, and LDAP directory services.</p>
 * 
 * <p>This document provides a platform neutral schema and extension model for representing users and groups in JSON format. 
 * This schema is intended for exchange and use with cloud service providers. 
 * Additional binding documents provide a standard REST API, SAML binding, and use cases.</p>
 * 
 * <h3>Definitions</h3>
 * 
 * <ul>
 * <li>Service Provider: A web application that provides identity information
 * via the SCIM protocol.</li>
 * 
 * <li>Consumer: A website or application that uses the SCIM protocol to manage
 * identity data maintained by the Service Provider.</li>
 * 
 * <li>Resource: The Service Provider managed artifact containing one or more
 * attributes; e.g., User or Group</li>
 * 
 * <li>Singular Attribute: A Resource attribute that contains 0..1 values; e.g.,
 * displayName.</li>
 * 
 * <li>Multi-valued Attribute: A Resource attribute that contains 0..n values;
 * e.g., emails.</li>
 * 
 * <li>Simple Attribute: A Singular or Multi-valued Attribute whose value is a
 * primitive; e.g., String.</li>
 * 
 * 
 * <li>Complex Attribute: A Singular or Multi-valued Attribute whose value is a
 * composition of one or more Simple Attributes.</li>
 * 
 * <li>Sub-Attribute: A Simple Attribute contained within a Complex Attribute.</li>
 * </ul>
 */
import javax.xml.bind.annotation.XmlSchema;

