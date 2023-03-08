package com.handy.sdk.beans;

public class ProductTax {
	private int id;
	private float amount;
	private String name;
	private boolean enabled;
	
	public ProductTax() {}

	public ProductTax(int id, float amount, String name, boolean enabled) {
		this.id = id;
		this.amount = amount;
		this.name = name;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
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
