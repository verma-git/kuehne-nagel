package com.kn.decathlon.execption;

public class DecathlonAppException extends RuntimeException{

	private final ExceptionType exceptionType;
	private final String errorMessage;
	
	public DecathlonAppException(String errorMessage, ExceptionType type) {
		super(errorMessage);
		this.exceptionType = type;
		this.errorMessage = errorMessage;
	}
	
}
