package com.dispense.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class InsufficientDenominationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientDenominationException(String message) {
		super(message);
	}
}
