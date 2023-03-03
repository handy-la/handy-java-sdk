package com.handy.sdk.exceptions;

public class HandySDKException extends Exception {
	private static final long serialVersionUID = -5175198688425116873L;

	public HandySDKException(String message) {
		super(message);
	}
	
	public HandySDKException(String message, Throwable err) {
		super(message, err);
	}
}
