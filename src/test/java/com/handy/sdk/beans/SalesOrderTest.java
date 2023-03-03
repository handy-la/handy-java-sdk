package com.handy.sdk.beans;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.json.JSONObject;
import org.junit.Test;
import com.handy.sdk.beans.SalesOrder;

public class SalesOrderTest {

	@Test
	public void SalesOrderFromJson() {
		InputStream is = this.getClass().getResourceAsStream("/SalesOrderExample.json");
		assertNotNull(is);

		BufferedReader responseReader;
		try {
			responseReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			StringBuilder responseStrBuilder = new StringBuilder();
			
			responseReader.lines().forEach(strLine -> responseStrBuilder.append(strLine));

			SalesOrder salesOrder = SalesOrder.fromJsonObject(new JSONObject(responseStrBuilder.toString()));
			
			assertEquals(salesOrder.getId(), 29079293);
			assertEquals(salesOrder.getItems().size(), 3);
			assertEquals(salesOrder.getItems().get(0).getProduct().getCode(), "M-001");
			
		} catch (UnsupportedEncodingException e) {
			fail("Exception when reading JSON file.");
		}
	}
	
	@Test
	public void SalesOrderToJson() {
		SalesOrder salesOrder = new SalesOrder();
		
		salesOrder.setId(123456);
		salesOrder.setTotalSales(15000);
		salesOrder.setTotalBeforeTax(10000);
		salesOrder.setTotalTax(5000);
		salesOrder.setMobileDateCreated(LocalDateTime.now());
		
		Product product = new Product();
		product.setId(15345);
		product.setCode("TST-001");
		product.setDescription("Super Cool Product");
		
		SalesOrderItem item = new SalesOrderItem();
		item.setProduct(product);
		item.setId(34634);
		item.setQuantity(3);
		
		salesOrder.setItems(new ArrayList<SalesOrderItem>());
		salesOrder.getItems().add(item);
		
		JSONObject jsonSalesOrder = salesOrder.toJsonObject();
		
		System.out.println(jsonSalesOrder.toString());
	}

}
