package com.handy.sdk.beans;

import java.util.List;

public class ProductResponse {
	private boolean success;
	private Product product;
	private List<ProductUnprocessableEntity> errors;
	
	public ProductResponse() {}
	
	public ProductResponse(List<ProductUnprocessableEntity> errors) {
		this.success = false;
		this.product = null;
		this.errors = errors;
	}
	
	public ProductResponse(Product product) {
		this.success = true;
		this.product = product;
		this.errors = null;
	}

	public boolean isSuccess() {
		return success;
	}

	public Product getProduct() {
		return product;
	}

	public List<ProductUnprocessableEntity> getErrors() {
		return errors;
	}
}
