package com.handy.sdk.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;

import com.handy.sdk.beans.Product;
import com.handy.sdk.beans.ProductResponse;
import com.handy.sdk.beans.ProductUnprocessableEntity;
import com.handy.sdk.enums.HTTPMethod;
import com.handy.sdk.exceptions.HandyAuthorizationException;
import com.handy.sdk.exceptions.HandySDKException;
import com.handy.sdk.util.APIController;
import com.handy.sdk.util.beans.APIRequest;
import com.handy.sdk.util.beans.APIResponse;

public class ProductController {
	private final String PATH = "/product";
	
	public ProductResponse postProduct(Product product) throws HandyAuthorizationException, HandySDKException {
		return postProduct(product, false);
	}
	
	private ProductResponse postProduct(Product product, boolean isRetry) throws HandyAuthorizationException, HandySDKException {
		
		APIController apiController = new APIController();
		APIRequest request = new APIRequest(HTTPMethod.POST, HandySDKConfiguration.getBaseUrl()+PATH, HandySDKConfiguration.getApiToken(), product.toJsonObject().toString());
		
		try {
			APIResponse response = apiController.call(request);
			
			switch(response.getCode()) {
			case 201:
				product.setId(response.getBody().getInt("id"));
				return new ProductResponse(product);
			case 401:
				throw new HandyAuthorizationException();
			case 422:
				ArrayList<ProductUnprocessableEntity> productUnprocessableEntityList = new ArrayList<>();
				
				response.getBody().getJSONArray("errors").forEach(error -> productUnprocessableEntityList.add(ProductUnprocessableEntity.fromJsonObject((JSONObject)error)));
				
				return new ProductResponse(productUnprocessableEntityList);
			case 429:
				if(HandySDKConfiguration.isAutoRetry() && !isRetry) {
					TimeUnit.MINUTES.sleep(1);
					return this.postProduct(product, true);
				}
			default:
				throw new HandySDKException("Unexpected error during Handy API call to create Product. Error code: " + response.getCode());
			
			}
			
		} catch(IOException | InterruptedException ex) {
			throw new HandySDKException("Error while creating Product.", ex);
		}
		
	}
}
