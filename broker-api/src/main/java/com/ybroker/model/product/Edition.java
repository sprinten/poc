package com.ybroker.model.product;

import java.util.List;

import com.ybroker.model.core.Service;

public class Edition extends Service {

	private String description;
	private List<License> licenses;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<License> getLicenses() {
		return licenses;
	}
	public void setLicenses(List<License> licenses) {
		this.licenses = licenses;
	}
}
