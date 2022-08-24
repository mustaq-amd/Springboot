package com.example.exception;

public class MobileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MobileNotFoundException(String message) {
		super(message);
	}

}
