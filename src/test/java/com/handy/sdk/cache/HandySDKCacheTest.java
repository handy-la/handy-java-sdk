package com.handy.sdk.cache;

import static org.junit.Assert.*;

import org.junit.Test;

public class HandySDKCacheTest {

	@Test
	public void handySDKCacheSingletonTest() {
		HandySDKCache cache1 = HandySDKCache.getInstance();
		HandySDKCache cache2 = HandySDKCache.getInstance();
		
		cache1.createOrReplaceCacheValue("SuperSecretKey", "ThisCouldBeOrCouldNotBeMyPassword");
		
		String value = String.valueOf(cache2.getCacheValue("SuperSecretKey"));
		
		assertEquals(value, "ThisCouldBeOrCouldNotBeMyPassword");
		
		cache2.getCacheValue("SuperSecretKey", true);
		
		assertNull(cache2.getCacheValue("SuperSecretKey"));
	}

}
