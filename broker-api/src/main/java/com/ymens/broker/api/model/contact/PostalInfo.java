package com.ymens.broker.api.model.contact;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

/**
 * Element that contain postal address information.
 */
@XmlType(name = "PostalInfo")
public class PostalInfo implements Serializable {

	private static final long serialVersionUID = 1l;

	private String name;

	private String firstName;

	private String lastName;

	private String title;

	private String salutation;

	private String organization;

	private Address address = new Address();

	/**
	 * The name.
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * The name.
	 * 
	 * @param name
	 *            The new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The organization.
	 * 
	 * @return The organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * The organization.
	 * 
	 * @param organization
	 *            The new organization
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * The first name.
	 * 
	 * @return The first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * The first name.
	 * 
	 * @param firstName
	 *            The new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * The last name.
	 * 
	 * @return The last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * The last name.
	 * 
	 * @param lastName
	 *            The new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * The title.
	 * 
	 * @return The title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * The title.
	 * 
	 * @param title
	 *            The new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * The salutation.
	 * 
	 * @return The salutation
	 */
	public String getSalutation() {
		return salutation;
	}

	/**
	 * The salutation.
	 * 
	 * @param salutation
	 *            The new salutation
	 */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	/**
	 * The address.
	 * 
	 * @return The address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * The address.
	 * 
	 * @param address
	 *            The new address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((organization == null) ? 0 : organization.hashCode());
		result = prime * result + ((salutation == null) ? 0 : salutation.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostalInfo other = (PostalInfo) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		if (salutation == null) {
			if (other.salutation != null)
				return false;
		} else if (!salutation.equals(other.salutation))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PostalInfo [name=" + name + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title
				+ ", salutation=" + salutation + ", organization=" + organization + ", address=" + address + "]";
	}

}