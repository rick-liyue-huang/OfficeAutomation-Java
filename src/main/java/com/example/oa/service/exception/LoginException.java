package com.example.oa.service.exception;

/**
 * focus on the exact exception on login business.
 */
public class LoginException extends RuntimeException {
	public LoginException(String message) {
		super(message);
	}
}
