package com.ybroker.model.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.ybroker.model.core.contact.Address;
import com.ybroker.model.core.contact.Contact;

/**
 * Unit Model. A specific type of group designated to hold the hierarchical
 * structure of an organization.
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlRootElement(name = "Unit")
public class Unit extends Group {

	public enum UnitType {
		ORGANIZATION, DIVISION, DEPARTMENT, TEAM
	}

	private UnitType unitType;
	private Address address;
	private Contact contact;

	public UnitType getUnitType() {
		return unitType;
	}

	public void setUnitType(UnitType unitType) {
		this.unitType = unitType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}
