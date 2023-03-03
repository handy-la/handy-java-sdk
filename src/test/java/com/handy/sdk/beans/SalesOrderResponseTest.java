package com.handy.sdk.beans;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.json.JSONObject;
import org.junit.Test;

public class SalesOrderResponseTest {

	@Test
	public void testFromJsonObject() {
		InputStream is = this.getClass().getResourceAsStream("/SalesOrderResponseExample.json");

		BufferedReader responseReader;
		try {
			responseReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			StringBuilder responseStrBuilder = new StringBuilder();
			
			responseReader.lines().forEach(strLine -> responseStrBuilder.append(strLine));

			SalesOrderResponse salesOrderResponse = SalesOrderResponse.fromJsonObject(new JSONObject(responseStrBuilder.toString()));
			
			assertEquals(salesOrderResponse.getPagination().getTotalCount(), 2);
			assertEquals(salesOrderResponse.getSalesOrderList().size(), 2);
			
		} catch (UnsupportedEncodingException e) {
			fail("Exception when reading JSON file.");
		}
	}

}
