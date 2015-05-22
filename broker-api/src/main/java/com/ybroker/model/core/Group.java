package com.ybroker.model.core;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.enunciate.doc.DocumentationExample;
import org.codehaus.enunciate.doc.ExampleType;

import com.google.gson.Gson;
import com.ybroker.model.core.base.Resource;

/**
 * <p>Group representation.</p>
 * 
 * <p>Group resources are meant to enable expression of common Group or role based
 * access control models, although no explicit authorization model is defined.
 * It is intended that the semantics of group membership and any behavior or
 * authorization granted as a result of membership are defined by the Service
 * Provider are considered out of scope for this specification.</p>
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(name = "Group", propOrder = { "schemas", "id", "externalId", "displayName", "groupType", "parent", "members", "meta" })
@XmlRootElement(name = "Group")
public class Group extends Resource {

	public static enum Type {
		ROLE, UNIT, SERVICE
	}
	
	private String displayName;
	private List<Resource> members;
	private Group parent;
	private Type groupType;

	/**
	 * A human readable name for the Group.
	 * 
	 * @return possible object is {@link String }
	 */
	@XmlElement(required = true)
	@DocumentationExample(validTypes = ExampleType.JSON, value = "Administrators")
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String value) {
		this.displayName = value;
	}

	/**
	 * A list of members of the Group. Canonical Types "User" and "Group" are
	 * READ-ONLY. The value must be the "id" of a SCIM resource, either a User,
	 * or a Group. The intention of the Group type is to allow the Service
	 * Provider to support nested Groups. Service Providers MAY require
	 * Consumers to provide a non-empty members value based on the "required"
	 * sub attribute of the "members" attribute in Group Resource Schema.
	 * 
	 * @return A list of members of the Group.
	 * 
	 */
	public List<Resource> getMembers() {
		return members;
	}

	public void setMembers(List<Resource> value) {
		this.members = value;
	}

	public Group getParent() {
		return parent;
	}

	public void setParent(Group parent) {
		this.parent = parent;
	}

	public Type getGroupType() {
		return groupType;
	}

	public void setGroupType(Type groupType) {
		this.groupType = groupType;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
