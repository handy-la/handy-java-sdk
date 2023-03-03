package com.handy.sdk.job.beans;

import java.util.Set;

import com.handy.sdk.beans.SalesOrder;
import com.handy.sdk.cache.HandySDKCache;

public class SalesOrderJobHandler implements JobHandler {

	@Override
	public void process(Set<SalesOrder> dataToProcess) {
		HandySDKCache cache = HandySDKCache.getInstance();
		
		Set<SalesOrder> data = dataToProcess;
		
		@SuppressWarnings("unchecked")
		Set<SalesOrder> currentCache = (Set<SalesOrder>)cache.getCacheValue("SalesOrderJobData");
		if(currentCache != null)
			data.addAll(currentCache);
		
		cache.createOrReplaceCacheValue("SalesOrderJobData", data);
	}

}
