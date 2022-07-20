package com.smbc.lad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SMBCResourceNotFoundException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;
	
	public SMBCResourceNotFoundException() {
        super();
    }
    public SMBCResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public SMBCResourceNotFoundException(String message) {
        super(message);
    }
    public SMBCResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}