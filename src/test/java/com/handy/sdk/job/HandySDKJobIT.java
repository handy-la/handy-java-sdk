package com.handy.sdk.job;

import static org.junit.Assert.*;

import java.util.Set;
import org.junit.Test;
import org.quartz.JobExecutionException;
import com.handy.sdk.beans.SalesOrder;
import com.handy.sdk.business.HandySDKConfiguration;
import com.handy.sdk.cache.HandySDKCache;
import com.handy.sdk.job.beans.SalesOrderJobHandler;

public class HandySDKJobIT {

	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		try {
        	HandySDKConfiguration.setAutoRetry(false);
			HandySDKConfiguration.setJobHandler(new SalesOrderJobHandler());
			
			HandySDKJob job = new HandySDKJob();
			job.execute(null);
			
			HandySDKCache cache = HandySDKCache.getInstance();
			
			Set<SalesOrder> set = (Set<SalesOrder>)cache.getCacheValue("SalesOrderJobData", true);
			for(Object sale : set.toArray()) {
				SalesOrder s = (SalesOrder)sale;
				System.out.println(s.toJsonObject().toString());
			}
			
			set = (Set<SalesOrder>)cache.getCacheValue("SalesOrderJobData");
			assertNull(set);
			
		} catch (JobExecutionException e) {
			fail(e.getMessage());
		}
	}

}
