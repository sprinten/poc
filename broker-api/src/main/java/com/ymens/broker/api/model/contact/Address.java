package com.ymens.broker.api.model.contact;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

/**
 * Representation of the contact address.
 */
@XmlType(name = "Address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1l;

	private List<String> streets = new ArrayList<String>(3);
	private String countryCode;
	private String postalCode;
	private String state;
	private String city;

	/**
	 * The streets.
	 * 
	 * @return The streets
	 */
	public List<String> getStreets() {
		return this.streets;
	}

	/**
	 * The streets.
	 * 
	 * @param streets
	 *            The new streets
	 */
	public void setStreets(List<String> streets) {
		this.streets = streets;
	}

	/**
	 * The contact's city.
	 * 
	 * @return The city
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * The contact's city.
	 * 
	 * @param city
	 *            The new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * The contact's state or province.
	 * 
	 * @return The state code
	 */
	public String getState() {
		return this.state;
	}

	/**
	 * The contact's state or province.
	 * 
	 * @param state
	 *            The new state code
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * The contact's postal code.
	 * 
	 * @return The postal code
	 */
	public String getPostalCode() {
		return this.postalCode;
	}

	/**
	 * The contact's postal code.
	 * 
	 * @param postalCode
	 *            The new postal code
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * The contact's country code.
	 * 
	 * @return The country code
	 */
	public String getCountryCode() {
		return this.countryCode;
	}

	/**
	 * The contact's country code.
	 * 
	 * @param countryCode
	 *            The new country code
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void addStreet(String street) {
		this.streets.add(street);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((streets == null) ? 0 : streets.hashCode());
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (streets == null) {
			if (other.streets != null)
				return false;
		} else if (!streets.equals(other.streets))
			return false;
		return true;
	}

    @Override
    public String toString() {
        return "Address [streets=" + streets + ", countryCode=" + countryCode + ", postalCode=" + postalCode
               + ", state=" + state + ", city=" + city + "]";
    }
	
	
}