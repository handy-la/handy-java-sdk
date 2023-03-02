package com.handy.sdk.business;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.handy.sdk.beans.SalesOrder;
import com.handy.sdk.beans.SalesOrderFilter;
import com.handy.sdk.beans.SalesOrderResponse;
import com.handy.sdk.exceptions.HandyAuthorizationException;
import com.handy.sdk.exceptions.HandySDKException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SalesOrderControllerIT {
	
	@Test
	public void getSalesOrder() {
		SalesOrderController salesOrderController = new SalesOrderController();
		
		try {
			SalesOrderResponse salesOrderResponse = salesOrderController.getSalesOrder(new SalesOrderFilter());
			
			assertTrue(salesOrderResponse.getPagination().getTotalCount() > 0);
			assertFalse(salesOrderResponse.getSalesOrderList().isEmpty());
			
		} catch (HandyAuthorizationException | HandySDKException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void getSalesOrderByID() {
		SalesOrderController salesOrderController = new SalesOrderController();
		
		try {
			SalesOrderResponse salesOrderResponse = salesOrderController.getSalesOrder(new SalesOrderFilter());

			int id = salesOrderResponse.getSalesOrderList().stream().findFirst().get().getId();
			
			
			SalesOrder salesOrder = salesOrderController.getSalesOrderByID(id);
			
			assertEquals(salesOrder.getId(), id);
			assertFalse(salesOrder.getItems().isEmpty());
		} catch (HandyAuthorizationException | HandySDKException e) {
			fail(e.getMessage());
		}
	}

}
