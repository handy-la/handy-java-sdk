package com.handy.sdk.beans;

import org.json.JSONObject;

import com.google.gson.Gson;

public class Customer {
	private int id;
	private String name;
	private String code;
	private String fiscalRegime; //
	private String address;
	private String comments;
	private int facturamaCustomerId; //
	private String city;
	private String postalCode;
	private String businessName;
	private String description;
	private PriceList priceList;
	private float balance;
	private Zone zone;
	private String cfdiUse; //
	private String paymentForms; //
	private String paymentMethods; //
	private String neighborhood;
	private float credit;
	private boolean enabled;
	
	public Customer() {}

	public Customer(int id, String name, String code, String fiscalRegime, String address, String comments,
			int facturamaCustomerId, String city, String postalCode, String businessName, String description,
			PriceList priceList, float balance, Zone zone, String cfdiUse, String paymentForms, String paymentMethods,
			String neighborhood, float credit, boolean enabled) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.fiscalRegime = fiscalRegime;
		this.address = address;
		this.comments = comments;
		this.facturamaCustomerId = facturamaCustomerId;
		this.city = city;
		this.postalCode = postalCode;
		this.businessName = businessName;
		this.description = description;
		this.priceList = priceList;
		this.balance = balance;
		this.zone = zone;
		this.cfdiUse = cfdiUse;
		this.paymentForms = paymentForms;
		this.paymentMethods = paymentMethods;
		this.neighborhood = neighborhood;
		this.credit = credit;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFiscalRegime() {
		return fiscalRegime;
	}

	public void setFiscalRegime(String fiscalRegime) {
		this.fiscalRegime = fiscalRegime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getFacturamaCustomerId() {
		return facturamaCustomerId;
	}

	public void setFacturamaCustomerId(int facturamaCustomerId) {
		this.facturamaCustomerId = facturamaCustomerId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PriceList getPriceList() {
		return priceList;
	}

	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public String getCfdiUse() {
		return cfdiUse;
	}

	public void setCfdiUse(String cfdiUse) {
		this.cfdiUse = cfdiUse;
	}

	public String getPaymentForms() {
		return paymentForms;
	}

	public void setPaymentForms(String paymentForms) {
		this.paymentForms = paymentForms;
	}

	public String getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(String paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public JSONObject toJsonObject() {
		Gson gson = new Gson();
		return new JSONObject(gson.toJson(this));
	}
	
	public static Customer fromJsonObject(JSONObject jsonCustomer) {
		Gson gson = new Gson();
		return gson.fromJson(jsonCustomer.toString(), Customer.class);
	}
	
	public static<T extends Customer> Customer fromSubClass(T customer) {
		return Customer.class.cast(customer);
	}
	
	public<T extends Customer> T toSubClass(Class<T> type) {
		return type.cast(this);
	}
}
