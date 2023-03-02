package com.handy.sdk.beans;

import java.util.HashSet;
import java.util.Set;

import org.json.JSONObject;

public class SalesOrderResponse {
	private Pagination pagination;
	private Set<SalesOrder> salesOrderList;
	
	public SalesOrderResponse() {}

	public SalesOrderResponse(Pagination pagination, Set<SalesOrder> salesOrderList) {
		this.pagination = pagination;
		this.salesOrderList = salesOrderList;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public Set<SalesOrder> getSalesOrderList() {
		return salesOrderList;
	}

	public void setSalesOrderList(Set<SalesOrder> salesOrderList) {
		this.salesOrderList = salesOrderList;
	}
	
	public static SalesOrderResponse fromJsonObject(JSONObject jsonSalesOrderResponse) {
		Pagination pagination = Pagination.fromJsonObject(jsonSalesOrderResponse.getJSONObject("pagination"));
		
		Set<SalesOrder> salesOrderList = new HashSet<>();
		jsonSalesOrderResponse.getJSONArray("salesOrders").forEach(salesOrder -> salesOrderList.add(SalesOrder.fromJsonObject((JSONObject)salesOrder)));
		
		return new SalesOrderResponse(pagination, salesOrderList);
	}
}
