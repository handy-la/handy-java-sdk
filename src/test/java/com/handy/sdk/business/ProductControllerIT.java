package com.handy.sdk.business;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.json.JSONObject;
import org.junit.Test;

import com.handy.sdk.beans.Product;
import com.handy.sdk.beans.ProductResponse;
import com.handy.sdk.exceptions.HandyAuthorizationException;
import com.handy.sdk.exceptions.HandySDKException;

public class ProductControllerIT {

	@Test
	public void testPostProductValid() {
		InputStream is = this.getClass().getResourceAsStream("/ValidProductExample.json");
		
		BufferedReader responseReader;
		try {
			responseReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			StringBuilder responseStrBuilder = new StringBuilder();
			
			responseReader.lines().forEach(strLine -> responseStrBuilder.append(strLine));

			Product product = Product.fromJsonObject(new JSONObject(responseStrBuilder.toString()));
			
			ProductController productController = new ProductController();
			ProductResponse response = productController.postProduct(product);
			
			assertNotNull(response.getProduct());
			assertNull(response.getErrors());
			
		} catch (UnsupportedEncodingException | HandyAuthorizationException | HandySDKException e) {
			fail("Exception when reading JSON file. " + e.getMessage());
		}
	}
	
	@Test
	public void testPostProductInvalid() {
		InputStream is = this.getClass().getResourceAsStream("/InvalidProductExample.json");
		
		BufferedReader responseReader;
		try {
			responseReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			StringBuilder responseStrBuilder = new StringBuilder();
			
			responseReader.lines().forEach(strLine -> responseStrBuilder.append(strLine));

			Product product = Product.fromJsonObject(new JSONObject(responseStrBuilder.toString()));
			
			ProductController productController = new ProductController();
			ProductResponse response = productController.postProduct(product);
			
			assertNull(response.getProduct());
			assertNotNull(response.getErrors());
			
		} catch (UnsupportedEncodingException | HandyAuthorizationException | HandySDKException e) {
			fail("Exception when reading JSON file. " + e.getMessage());
		}
	}

}
