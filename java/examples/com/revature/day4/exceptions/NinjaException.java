package com.revature.day4.exceptions;

public class NinjaException extends RuntimeException {

	private static final long serialVersionUID = -5110400822090502621L;
	
	public NinjaException() {
		super("I'm sneaky.");
	}
}
