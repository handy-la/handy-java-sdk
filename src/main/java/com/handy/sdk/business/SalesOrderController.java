package com.handy.sdk.business;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.handy.sdk.beans.SalesOrder;
import com.handy.sdk.beans.SalesOrderFilter;
import com.handy.sdk.beans.SalesOrderResponse;
import com.handy.sdk.enums.HTTPMethod;
import com.handy.sdk.exceptions.HandyAuthorizationException;
import com.handy.sdk.exceptions.HandySDKException;
import com.handy.sdk.util.APIController;
import com.handy.sdk.util.beans.APIRequest;
import com.handy.sdk.util.beans.APIResponse;

public class SalesOrderController {
	private final String PATH = "/salesOrder";
	
	public SalesOrderResponse getSalesOrder(SalesOrderFilter filter) throws HandyAuthorizationException, HandySDKException {
		return getSalesOrder(filter, false);
	}
	
	private SalesOrderResponse getSalesOrder(SalesOrderFilter filter, boolean isRetry) throws HandyAuthorizationException, HandySDKException {
		
		APIController apiController = new APIController();
		APIRequest request = new APIRequest(HTTPMethod.GET, HandySDKConfiguration.getBaseUrl()+PATH+filter.toString(), HandySDKConfiguration.getApiToken());
		
		try {
			APIResponse response = apiController.call(request);
			
			switch(response.getCode()) {
			case 200:
				return SalesOrderResponse.fromJsonObject(response.getBody());
			case 401:
				throw new HandyAuthorizationException();
			case 429:
				if(HandySDKConfiguration.isAutoRetry() && !isRetry) {
					TimeUnit.MINUTES.sleep(1);
					return this.getSalesOrder(filter, true);
				}
			default:
				throw new HandySDKException("Unexpected error during Handy API call to get Sales Order list. Error code: " + response.getCode());
			
			}
			
		} catch(IOException | InterruptedException ex) {
			throw new HandySDKException("Error while getting Sales Order list.", ex);
		}
	}

	public SalesOrder getSalesOrderByID(int id) throws HandyAuthorizationException, HandySDKException {
		return this.getSalesOrderByID(id, false);
	}
	
	private SalesOrder getSalesOrderByID(int id, boolean isRetry) throws HandyAuthorizationException, HandySDKException {
		
		APIController apiController = new APIController();
		APIRequest request = new APIRequest(HTTPMethod.GET, HandySDKConfiguration.getBaseUrl()+PATH+"/"+id, HandySDKConfiguration.getApiToken());
		
		try {
			APIResponse response = apiController.call(request);
			
			switch(response.getCode()) {
			case 200:
				return SalesOrder.fromJsonObject(response.getBody());
			case 401:
				throw new HandyAuthorizationException();
			case 429:
				if(HandySDKConfiguration.isAutoRetry() && !isRetry) {
					TimeUnit.MINUTES.sleep(1);
					return this.getSalesOrderByID(id, true);
				}
			case 404:
				return new SalesOrder();
			default:
				throw new HandySDKException("Error while getting Sales Order by ID. Error code: " + response.getCode());
			}
			
			
		} catch(IOException | InterruptedException ex) {
			throw new HandySDKException("Error while getting Sales Order by ID.", ex);
		}
	}
}
