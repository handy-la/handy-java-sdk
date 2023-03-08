package com.handy.sdk.beans;

public class ProductUnit {
	private int id;
	private String code;
	private String description;
	private boolean enabled;
	
	public ProductUnit(){}

	public ProductUnit(int id, String code, String description, boolean enabled) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
