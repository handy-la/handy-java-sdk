package com.handy.sdk;

import com.handy.sdk.business.HandySDKConfiguration;
import com.handy.sdk.exceptions.HandySDKException;
import com.handy.sdk.job.HandySDKJobScheduler;
import com.handy.sdk.job.beans.JobHandler;
import com.handy.sdk.job.beans.SalesOrderJobHandler;

public class HandySDK 
{
    public static void init() throws HandySDKException {
    	init(false);
    }
    
    public static void init(boolean autoRetry) throws HandySDKException {
    	init(autoRetry, new SalesOrderJobHandler());
    }
    
    public static void init(JobHandler jobHandler) throws HandySDKException {
    	init(false, jobHandler);
    }
    
    public static void init(boolean autoRetry, JobHandler jobHandler) throws HandySDKException {
    	HandySDKConfiguration.setAutoRetry(autoRetry);
    	HandySDKConfiguration.setJobHandler(jobHandler);
    	
    	try {
			HandySDKJobScheduler.startJob();
		} catch (HandySDKException e) {
			throw new HandySDKException("Error during init() while starting HandySDKJob.", e);
		}
    }
}
