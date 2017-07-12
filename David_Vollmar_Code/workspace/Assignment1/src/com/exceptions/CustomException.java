package com.exceptions;

public class CustomException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "You been caught by the police";
	}
}
