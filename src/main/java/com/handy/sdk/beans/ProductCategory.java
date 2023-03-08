package com.handy.sdk.beans;

public class ProductCategory {
	private int id;
	private String description;
	private boolean enabled;
	
	public ProductCategory() {}

	public ProductCategory(int id, String description, boolean enabled) {
		this.id = id;
		this.description = description;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
