package com.demo.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseStatusException exception(UserNotFoundException e) {
		return new ResponseStatusException(
		           HttpStatus.NOT_FOUND, e.getMessage(),e);
		
	}
}
