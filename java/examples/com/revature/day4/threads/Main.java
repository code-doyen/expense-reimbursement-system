package com.revature.day4.threads;

public class Main {
	
	public static void main(String args[]) throws Exception {
		//Runnable way ***
		//new Thread(new RunnableClass()).start();
		//System.out.println("Hello");
		
		//Thread way ***
		AwesomeThread t1 = new AwesomeThread();
		t1.threadNumber = 1;
		t1.start();
		System.out.println(t1.isAlive()); //Tells you if a thread still runs
		
		AwesomeThread t2 = new AwesomeThread();
		t2.threadNumber = 2;
		t2.start();
		t2.join(); //Makes main process wait for t2 to finish.
		System.out.println(t2.isAlive());
		
		AwesomeThread t3 = new AwesomeThread();
		t3.threadNumber = 3;
		t3.start();
	}
}
