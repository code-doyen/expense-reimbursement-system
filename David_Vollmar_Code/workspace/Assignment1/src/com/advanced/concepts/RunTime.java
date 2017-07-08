package com.advanced.concepts;

public class RunTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime r = Runtime.getRuntime();
		
		System.out.println("Memory Allocated " + r.totalMemory()); //memory available
		r.gc(); //clean up garbage
		System.out.println("Memory Available " + r.freeMemory()); //memory available
	}// pretty much I would use these three to see how much memory I am using and can free at any given time

}
