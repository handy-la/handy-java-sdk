package com.handy.sdk.beans;

public class ProductUnit {
	private int id;
	private String code;
	private String description;
	private boolean enabled;
	
	public ProductUnit(){}

	public ProductUnit(int id, String codigo, String descripcion, boolean habilitado) {
		this.id = id;
		this.code = codigo;
		this.description = descripcion;
		this.enabled = habilitado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return code;
	}

	public void setCodigo(String codigo) {
		this.code = codigo;
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
