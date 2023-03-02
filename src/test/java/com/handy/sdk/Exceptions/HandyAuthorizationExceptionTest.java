package com.handy.sdk.Exceptions;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.handy.sdk.exceptions.HandyAuthorizationException;

public class HandyAuthorizationExceptionTest {

	@Test
	public void catchingHandyAuthorizationException() {
		try {
			throwException();
		} catch (HandyAuthorizationException e) {
			assertTrue(true);
			return;
		}
		
		fail("Exception not generated");
	}
	
	@Test
	public void catchingHandyAuthorizationExceptionWithCustomMessage() {
		try {
			throwExceptionWithCustomMessage();
		} catch (HandyAuthorizationException e) {
			assertEquals("Message is not the expected.", "Customized Message Exception",e.getMessage());
			return;
		}
		
		fail("Exception not generated");
	}
	
	private void throwException() throws HandyAuthorizationException {
		throw new HandyAuthorizationException();
	}
	
	private void throwExceptionWithCustomMessage() throws HandyAuthorizationException {
		throw new HandyAuthorizationException("Customized Message Exception");
	}

}
