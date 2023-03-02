package com.handy.sdk.business;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HandySDKConfigurationTest {
	
	@Test
	public void getApiToken() {
		String apiToken = HandySDKConfiguration.getApiToken();
		assertTrue(apiToken.startsWith("Bearer "));
		//assertTrue(apiToken.equals("Bearer [HANDY_API_TOKEN]"));
	}

}
