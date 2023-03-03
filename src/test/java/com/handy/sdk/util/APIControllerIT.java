package com.handy.sdk.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.handy.sdk.enums.HTTPMethod;
import com.handy.sdk.util.APIController;
import com.handy.sdk.util.beans.APIRequest;
import com.handy.sdk.util.beans.APIResponse;

public class APIControllerIT {
	
	String apiToken;
	
	@Before
	public void init() {
		apiToken = "Bearer " + System.getenv("HANDY_API_TOKEN");
	}

	@Test
	public void testToken() {
		APIController apiController = new APIController();
		APIRequest apiRequest = new APIRequest(HTTPMethod.GET,"https://app.handy.la/api/v2/user", apiToken);
		
		try {
			APIResponse apiResponse = apiController.call(apiRequest);
			
			assertEquals(200, apiResponse.getCode());
		} catch (IOException ex) {
			fail(ex.getMessage());
		}
	}

}
