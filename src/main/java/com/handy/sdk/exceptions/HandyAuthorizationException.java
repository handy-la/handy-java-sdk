package com.handy.sdk.exceptions;

/**
 * HandyAuthorizationExceptions manages all Handy API Token related errors.
 */
public class HandyAuthorizationException extends Exception {
	private static final long serialVersionUID = 3995297971394186848L;
	
	public HandyAuthorizationException() {
		super("Authorization error during Handy API call. API Response: 401 Unauthorized.");
	}
	
	public HandyAuthorizationException(String message) {
		super(message);
	}
}
