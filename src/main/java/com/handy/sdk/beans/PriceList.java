package com.handy.sdk.beans;

public class PriceList {
	private int id;
	private String code;
	private String name;
	private boolean enabled;
	
	public PriceList(){}

	public PriceList(int id, String code, String name, boolean enabled) {
		this.id = id;
		this.code = code;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
