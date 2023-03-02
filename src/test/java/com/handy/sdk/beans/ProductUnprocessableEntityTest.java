package com.handy.sdk.beans;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.json.JSONObject;
import org.junit.Test;

public class ProductUnprocessableEntityTest {

	@Test
	public void testFromJsonObject() {
		InputStream is = this.getClass().getResourceAsStream("/ProductUnprocessableEntityExample.json");

		BufferedReader responseReader;
		try {
			responseReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			StringBuilder responseStrBuilder = new StringBuilder();
			
			responseReader.lines().forEach(strLine -> responseStrBuilder.append(strLine));

			ProductUnprocessableEntity productUnprocessableEntity = ProductUnprocessableEntity.fromJsonObject(new JSONObject(responseStrBuilder.toString()));
			
			assertEquals(productUnprocessableEntity.getObject(), "com.locus.product.Product");
			assertEquals(productUnprocessableEntity.getField(), "price");
			assertEquals(productUnprocessableEntity.getRejectedValue(), "$500.00");
			assertEquals(productUnprocessableEntity.getMessage(), "La propiedad Precio debe ser un número válido");
			
		} catch (UnsupportedEncodingException e) {
			fail("Exception when reading JSON file.");
		}
	}
	
	@Test
	public void testListFromJsonObject() {
		InputStream is = this.getClass().getResourceAsStream("/ProductUnprocessableEntityListExample.json");

		BufferedReader responseReader;
		try {
			responseReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			StringBuilder responseStrBuilder = new StringBuilder();
			
			responseReader.lines().forEach(strLine -> responseStrBuilder.append(strLine));

			ArrayList<ProductUnprocessableEntity> productUnprocessableEntityList = new ArrayList<>();
			
			JSONObject jsonResponse = new JSONObject(responseStrBuilder.toString());
			jsonResponse.getJSONArray("errors").forEach(error -> productUnprocessableEntityList.add(ProductUnprocessableEntity.fromJsonObject((JSONObject)error)));
			
			assertEquals(productUnprocessableEntityList.size(), 3);
			assertEquals(productUnprocessableEntityList.get(1).getObject(), "com.locus.product.Product");
			assertEquals(productUnprocessableEntityList.get(1).getField(), "family");
			assertNull(productUnprocessableEntityList.get(2).getRejectedValue());
			assertEquals(productUnprocessableEntityList.get(0).getMessage(), "La propiedad Precio debe ser un número válido");
			
		} catch (UnsupportedEncodingException e) {
			fail("Exception when reading JSON file.");
		}
	}

}
