package com.handy.sdk.beans;

public class PriceList {
	private int id;
	private String code;
	private String name;
	private boolean enabled;
	
	public PriceList(){}
	
	public PriceList(int id, String codigo, String nombre, boolean habilitada) {
		this.id = id;
		this.code = codigo;
		this.name = nombre;
		this.enabled = habilitada;
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
	public String getNombre() {
		return name;
	}
	public void setNombre(String nombre) {
		this.name = nombre;
	}
	public boolean isHabilitada() {
		return enabled;
	}
	public void setHabilitada(boolean habilitada) {
		this.enabled = habilitada;
	}
	
	
}
