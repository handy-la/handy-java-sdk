package com.handy.sdk.beans;

public class SalesOrderItem {
	private int id;
	private boolean isReturn;
	private Product product;
	private float quantity;
	private String comments;
	private float originalPrice;
	private boolean isReward;
	private ProductTax taxOptional;
	private String priceType;
	private String discount;
	private float delivered;
	private ProductTax tax;
	private String promoIds;
	private float discountPercentage;
	private float total;
	private float price;
	private String promoNames;
	
	public SalesOrderItem() {}

	public SalesOrderItem(int id, boolean isReturn, Product product, float quantity, String comments,
			float originalPrice, boolean isReward, ProductTax taxOptional, String priceType, String discount,
			float delivered, ProductTax tax, String promoIds, float discountPercentage, float total, float price,
			String promoNames) {
		this.id = id;
		this.isReturn = isReturn;
		this.product = product;
		this.quantity = quantity;
		this.comments = comments;
		this.originalPrice = originalPrice;
		this.isReward = isReward;
		this.taxOptional = taxOptional;
		this.priceType = priceType;
		this.discount = discount;
		this.delivered = delivered;
		this.tax = tax;
		this.promoIds = promoIds;
		this.discountPercentage = discountPercentage;
		this.total = total;
		this.price = price;
		this.promoNames = promoNames;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isReturn() {
		return isReturn;
	}

	public void setReturn(boolean isReturn) {
		this.isReturn = isReturn;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public float getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(float originalPrice) {
		this.originalPrice = originalPrice;
	}

	public boolean isReward() {
		return isReward;
	}

	public void setReward(boolean isReward) {
		this.isReward = isReward;
	}

	public ProductTax getTaxOptional() {
		return taxOptional;
	}

	public void setTaxOptional(ProductTax taxOptional) {
		this.taxOptional = taxOptional;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public float getDelivered() {
		return delivered;
	}

	public void setDelivered(float delivered) {
		this.delivered = delivered;
	}

	public ProductTax getTax() {
		return tax;
	}

	public void setTax(ProductTax tax) {
		this.tax = tax;
	}

	public String getPromoIds() {
		return promoIds;
	}

	public void setPromoIds(String promoIds) {
		this.promoIds = promoIds;
	}

	public float getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPromoNames() {
		return promoNames;
	}

	public void setPromoNames(String promoNames) {
		this.promoNames = promoNames;
	}
}
