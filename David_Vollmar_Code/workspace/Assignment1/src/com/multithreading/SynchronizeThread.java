package com.multithreading;

import java.util.Set;
import java.util.TreeSet;

public class SynchronizeThread extends Thread{
	private Set<Integer> counts = new TreeSet<>();
	public int threadNumber;
	@Override
	public synchronized void run(){
		for (int i = 1; i <= 1000; i++) {
			setCount(i);
		}
	}
	public synchronized Set<Integer> getCounts() {
		return this.counts;
	}
	public synchronized void setCount(int count) {
		counts.add(count);
	}
	
	
}
