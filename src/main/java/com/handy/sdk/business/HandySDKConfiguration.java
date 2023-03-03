package com.handy.sdk.business;

import com.handy.sdk.job.beans.JobHandler;

public final class HandySDKConfiguration {
	private static final String API_TOKEN = "Bearer " + System.getenv("HANDY_API_TOKEN");
	private static final String BASE_URL = "https://app.handy.la/api/v2";
	private static boolean autoRetry;
	private static JobHandler jobHandler;
	
	protected static String getApiToken() {
		return API_TOKEN;
	}

	protected static String getBaseUrl() {
		return BASE_URL;
	}

	public static boolean isAutoRetry() {
		return autoRetry;
	}

	public static void setAutoRetry(boolean autoRetry) {
		HandySDKConfiguration.autoRetry = autoRetry;
	}

	public static JobHandler getJobHandler() {
		return jobHandler;
	}

	public static void setJobHandler(JobHandler jobHandler) {
		HandySDKConfiguration.jobHandler = jobHandler;
	}
	
}
