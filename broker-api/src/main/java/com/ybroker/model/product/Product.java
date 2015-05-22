package com.ybroker.model.product;

import java.util.List;

import com.ybroker.model.core.Application;

public class Product extends Application {

	private String description;
	private List<Edition> editions;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Edition> getEditions() {
		return editions;
	}
	public void setEditions(List<Edition> editions) {
		this.editions = editions;
	}
	
	
}
