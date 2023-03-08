package com.handy.sdk.beans;

public class User {
	private int id;
	private String name;
	private String extras;
	private String username;
	private boolean enabled;
	
	public User() {}

	public User(int id, String name, String extras, String username, boolean enabled) {
		this.id = id;
		this.name = name;
		this.extras = extras;
		this.username = username;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
}
