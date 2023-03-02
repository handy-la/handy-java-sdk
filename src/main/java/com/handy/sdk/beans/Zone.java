package com.handy.sdk.beans;

public class Zone {
	private int id;
	private String color;
	private String description;
	private boolean enabled;
	
	public Zone() {}
	
	public Zone(int id, String color, String descripcion, boolean habilitada) {
		this.id = id;
		this.color = color;
		this.description = descripcion;
		this.enabled = habilitada;
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

	public String getDescripcion() {
		return description;
	}

	public void setDescripcion(String descripcion) {
		this.description = descripcion;
	}

	public boolean isHabilitada() {
		return enabled;
	}

	public void setHabilitada(boolean habilitada) {
		this.enabled = habilitada;
	}
}
