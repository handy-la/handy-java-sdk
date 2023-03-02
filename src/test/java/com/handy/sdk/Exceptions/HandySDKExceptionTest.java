package com.handy.sdk.Exceptions;

import static org.junit.Assert.*;

import org.junit.Test;

import com.handy.sdk.exceptions.HandySDKException;

public class HandySDKExceptionTest {

	@Test
	public void catchingHandySDKException() {
		try {
			throwException();
		} catch (HandySDKException e) {
			assertTrue(true);
			return;
		}
		
		fail("Exception not generated");
	}
	
	@Test
	public void catchingHandySDKExceptionWithCustomMessage() {
		try {
			throwExceptionWithCustomMessage();
		} catch (HandySDKException e) {
			assertEquals("Message is not the expected.", "Customized Message Exception",e.getMessage());
			return;
		}
		
		fail("Exception not generated");
	}
	
	private void throwException() throws HandySDKException {
		throw new HandySDKException("Fatal Warning!!", new HandySDKException("Super Fatal!!"));
	}
	
	private void throwExceptionWithCustomMessage() throws HandySDKException {
		throw new HandySDKException("Customized Message Exception");
	}

}
