package com.handy.sdk.beans;

public class Zone {
	private int id;
	private String color;
	private String description;
	private boolean enabled;
	
	public Zone() {}
	
	public Zone(int id, String color, String description, boolean enabled) {
		this.id = id;
		this.color = color;
		this.description = description;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
