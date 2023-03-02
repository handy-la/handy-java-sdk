package com.handy.sdk.beans;

public class User {
	private int id;
	private String name;
	private String extras;
	private String username;
	private boolean enabled;
	
	public User() {}

	public User(int id, String nombre, String extras, String username, boolean habilitado) {
		this.id = id;
		this.name = nombre;
		this.extras = extras;
		this.username = username;
		this.enabled = habilitado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return name;
	}

	public void setNombre(String nombre) {
		this.name = nombre;
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

	public boolean isHabilitado() {
		return enabled;
	}

	public void setHabilitado(boolean habilitado) {
		this.enabled = habilitado;
	}
}
