package com.handy.sdk.beans;

public class ProductFamily {
	private int id;
	private String description;
	private boolean enabled;
	
	public ProductFamily() {}

	public ProductFamily(int id, String descripcion, boolean habilitado) {
		this.id = id;
		this.description = descripcion;
		this.enabled = habilitado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return description;
	}

	public void setDescripcion(String descripcion) {
		this.description = descripcion;
	}

	public boolean isHabilitado() {
		return enabled;
	}

	public void setHabilitado(boolean habilitado) {
		this.enabled = habilitado;
	}
}