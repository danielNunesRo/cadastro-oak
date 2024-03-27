package com.danielnunesro.cadastro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super("The requested resource was not found in the database.");
	}
	
	public ResourceNotFoundException(String ex) {
		super(ex);
	}
	
}
