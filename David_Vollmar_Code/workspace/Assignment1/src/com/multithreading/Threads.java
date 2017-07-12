package com.multithreading;

import java.util.ConcurrentModificationException;

public class Threads {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		SynchronizeThread t1 = new SynchronizeThread();
		SynchronizeThread t2 = new SynchronizeThread();
		SynchronizeThread t3 = new SynchronizeThread();
		
		t1.threadNumber = 1;
		t1.start();
		t2.threadNumber = 2;
		t2.start();
		//t2.join();
		t3.threadNumber = 3;
		t3.start();
		//t3.join();
		
		
		System.out.println(t1.getCounts());
		System.out.println(t2.getCounts());
		System.out.println(t3.getCounts());
	}
	
}
