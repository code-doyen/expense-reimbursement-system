package com.revature.day4.threads;

public class AwesomeThread extends Thread {
	
	int threadNumber;
	
	@Override
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Welcome to the Java "+threadNumber);
	}
}
