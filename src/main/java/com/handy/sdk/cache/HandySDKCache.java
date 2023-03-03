package com.handy.sdk.cache;

import java.util.HashMap;
import java.util.Map;

public class HandySDKCache {
	private Map<String, Object> data;
	private static HandySDKCache handySDKCacheInstance;
	
	private HandySDKCache() {
		data = new HashMap<>();
	}
	
	public static HandySDKCache getInstance() {
		if(handySDKCacheInstance == null)
			handySDKCacheInstance = new HandySDKCache();
		
		return handySDKCacheInstance;
	}

	public Object getCacheValue(String key) {
		return getCacheValue(key, false);
	}
	public Object getCacheValue(String key, boolean deleteAfter) {
		if(!data.containsKey(key))
			return null;
		Object value = data.get(key);
		if(deleteAfter)
			data.remove(key);
		return value;
	}
	
	public void createOrReplaceCacheValue(String key, Object value) {
		data.put(key, value);
	}
	
}
