package com.revature.day4.exceptions;

public class Driver {
	//Checked Exception
	public static void attentionGuyThrower() throws AttentionGuyException {
		//Logic
		throw new AttentionGuyException();
	}
	
	//Unchecked Exception
	public static void ninjaThrower() throws NinjaException {
		//Logic
		throw new NinjaException();
	}
	
	public static void main(String[] args) {
		//I need a try catch block.
		try {
			attentionGuyThrower();
		} catch (AttentionGuyException e) {
			System.out.println(e);
		}
		
		try {
		//With no try catch, nothing else in my app will run.
			ninjaThrower();
		} catch (NinjaException e) {
			System.out.println(e);
		} catch (Throwable t) {
			//This cannot go before.
		}
		
		System.out.println("Will I run?");
		
		//throw null; // OCA
		
		//The invincible
		try {
			throw new OutOfMemoryError();
		}
		finally {
			//I'm always going to run.
			System.out.println("I don't care.");
		}
	}
}
