package com.handy.sdk.beans;

public class ProductTax {
	private int id;
	private float amount;
	private String name;
	private boolean enabled;
	
	public ProductTax() {}

	public ProductTax(int id, float monto, String nombre, boolean habilitado) {
		this.id = id;
		this.amount = monto;
		this.name = nombre;
		this.enabled = habilitado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getMonto() {
		return amount;
	}

	public void setMonto(float monto) {
		this.amount = monto;
	}

	public String getNombre() {
		return name;
	}

	public void setNombre(String nombre) {
		this.name = nombre;
	}

	public boolean isHabilitado() {
		return enabled;
	}

	public void setHabilitado(boolean habilitado) {
		this.enabled = habilitado;
	}
}
