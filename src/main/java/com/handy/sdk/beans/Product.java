package com.handy.sdk.beans;

import org.json.JSONObject;
import com.google.gson.Gson;

public class Product {
	private int id;
	private String code;
	private ProductTax taxOptional;
	private String description;
	private String satProductCode; //
	private String satProduct; //
	private float price;
	private String details;
	private float minimumPrice;
	private String barcode;
	private float basePrice;
	private float quantity;
	private boolean boostSales;
	private String satUnitCode;
	private String pictureUrl;
	private int externalId;
	private ProductTax tax;
	private String boostSalesDescription;
	private ProductUnit unit;
	private boolean hasBeenSold;
	private String satUnit; //
	private boolean applyDiscounts;
	private ProductFamily family;
	private ProductCategory category;
	private boolean enabled;
	
	public Product() {}

	public Product(int id, String code, ProductTax taxOptional, String description, String satProductCode,
			String satProduct, float price, String details, float minimumPrice, String barcode, float basePrice,
			float quantity, boolean boostSales, String satUnitCode, String pictureUrl, int externalId,
			ProductTax tax, String boostSalesDescription, ProductUnit unit, boolean hasBeenSold, String satUnit,
			boolean applyDiscounts, ProductFamily family, ProductCategory category, boolean enabled) {
		this.id = id;
		this.code = code;
		this.taxOptional = taxOptional;
		this.description = description;
		this.satProductCode = satProductCode;
		this.satProduct = satProduct;
		this.price = price;
		this.details = details;
		this.minimumPrice = minimumPrice;
		this.barcode = barcode;
		this.basePrice = basePrice;
		this.quantity = quantity;
		this.boostSales = boostSales;
		this.satUnitCode = satUnitCode;
		this.pictureUrl = pictureUrl;
		this.externalId = externalId;
		this.tax = tax;
		this.boostSalesDescription = boostSalesDescription;
		this.unit = unit;
		this.hasBeenSold = hasBeenSold;
		this.satUnit = satUnit;
		this.applyDiscounts = applyDiscounts;
		this.family = family;
		this.category = category;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ProductTax getTaxOptional() {
		return taxOptional;
	}

	public void setTaxOptional(ProductTax taxOptional) {
		this.taxOptional = taxOptional;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSatProductCode() {
		return satProductCode;
	}

	public void setSatProductCode(String satProductCode) {
		this.satProductCode = satProductCode;
	}

	public String getSatProduct() {
		return satProduct;
	}

	public void setSatProduct(String satProduct) {
		this.satProduct = satProduct;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public float getMinimumPrice() {
		return minimumPrice;
	}

	public void setMinimumPrice(float minimumPrice) {
		this.minimumPrice = minimumPrice;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public boolean isBoostSales() {
		return boostSales;
	}

	public void setBoostSales(boolean boostSales) {
		this.boostSales = boostSales;
	}

	public String getSatUnitCode() {
		return satUnitCode;
	}

	public void setSatUnitCode(String satUnitCode) {
		this.satUnitCode = satUnitCode;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public int getExternalId() {
		return externalId;
	}

	public void setExternalId(int externalId) {
		this.externalId = externalId;
	}

	public ProductTax getTax() {
		return tax;
	}

	public void setTax(ProductTax tax) {
		this.tax = tax;
	}

	public String getBoostSalesDescription() {
		return boostSalesDescription;
	}

	public void setBoostSalesDescription(String boostSalesDescription) {
		this.boostSalesDescription = boostSalesDescription;
	}

	public ProductUnit getUnit() {
		return unit;
	}

	public void setUnit(ProductUnit unit) {
		this.unit = unit;
	}

	public boolean isHasBeenSold() {
		return hasBeenSold;
	}

	public void setHasBeenSold(boolean hasBeenSold) {
		this.hasBeenSold = hasBeenSold;
	}

	public String getSatUnit() {
		return satUnit;
	}

	public void setSatUnit(String satUnit) {
		this.satUnit = satUnit;
	}

	public boolean isApplyDiscounts() {
		return applyDiscounts;
	}

	public void setApplyDiscounts(boolean applyDiscounts) {
		this.applyDiscounts = applyDiscounts;
	}

	public ProductFamily getFamily() {
		return family;
	}

	public void setFamily(ProductFamily family) {
		this.family = family;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	};

	public JSONObject toJsonObject() {
		Gson gson = new Gson();
		return new JSONObject(gson.toJson(this));
	}
	
	public static Product fromJsonObject(JSONObject jsonProduct) {
		Gson gson = new Gson();
		return gson.fromJson(jsonProduct.toString(), Product.class);
	}
	
	public static<T extends Product> Product fromSubClass(T product) {
		return Product.class.cast(product);
	}
	
	public<T extends Product> T toSubClass(Class<T> type) {
		return type.cast(this);
	}
}
