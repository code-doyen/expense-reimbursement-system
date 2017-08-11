package com.revature.service;

import org.springframework.stereotype.Service;

@Service("simpleService")
public class SimpleService {
	
	public void printMessage(String message) {
		//LOGGING WOULD BE HERE FOR BEFORE WITHOUT AOP.
		
		System.out.println("The message: " + message);
		
		//LOGGING WOULD BE HERE FOR AFTER WITHOUT AOP.
	}
	
	public void printNumber(int n) {
		//LOGGING WOULD BE HERE FOR BEFORE WITHOUT AOP.
		
		System.out.println("The number: " + n);
		
		//LOGGING WOULD BE HERE FOR AFTER WITHOUT AOP.
	}
	
	public int returnNumber(int n) {
		return n;
	}
	
	public void ejectDouble(double d) throws Exception {
		System.out.println("The double: " + d);
		
		throw new Exception("Here we go.");
	}
}
