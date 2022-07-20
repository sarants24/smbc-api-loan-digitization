package com.smbc.lad.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
public class SMBCBusinessException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;
	
	public SMBCBusinessException() {
        super();
    }
    public SMBCBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
    public SMBCBusinessException(String message) {
        super(message);
    }
    public SMBCBusinessException(Throwable cause) {
        super(cause);
    }
}