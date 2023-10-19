package com.demo.exceptionHandler;

public class UserNotFoundException extends RuntimeException{
 
	private static final long serialVersionUID = 1L;
	String message;
	
	public UserNotFoundException(String s){
		message=s;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
