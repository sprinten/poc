package com.ybroker.model.core.enterprise;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.Gson;
import com.ybroker.model.core.Unit;
import com.ybroker.model.core.User;

/**
 * Enterprise User representation.
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(name = "User", propOrder = { "schemas", "id", "externalId",
		"userName", "name", "displayName", "userType", "nickName", "profileUrl", "title",
		"userType", "preferredLanguage", "locale", "timezone", "active",
		"password", "emails", "phoneNumbers", "ims", "photos", "addresses",
		"groups", "entitlements", "roles", "x509Certificates", "employeeNumber", "costCenter", "organization", "division", "department", "manager" })
@XmlRootElement(name = "User")
public class EnterpriseUser extends User {

	/* Enterprise */

	private String employeeNumber;
	private String costCenter;
	private Unit organization;
	private Unit division;
	private Unit department;
	private Manager manager;

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public Unit getOrganization() {
		return organization;
	}

	public void setOrganization(Unit organization) {
		this.organization = organization;
	}

	public Unit getDivision() {
		return division;
	}

	public void setDivision(Unit division) {
		this.division = division;
	}

	public Unit getDepartment() {
		return department;
	}

	public void setDepartment(Unit department) {
		this.department = department;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
