package com.dispense.util;

import org.springframework.http.HttpStatus;

public class ApiError {
	 
    private HttpStatus status;
    private String message;
 
    public ApiError(HttpStatus status, String messag) {
        this.status = status;
        this.message = message;
    }
 
}