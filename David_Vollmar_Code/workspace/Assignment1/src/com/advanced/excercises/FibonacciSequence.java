package com.advanced.excercises;

public class FibonacciSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i =0; i < 100; i++){
			System.out.println(i+":"+getFibonacciSequence(i));
		}
	}
	
	public static long getFibonacciSequence(int i){
		
		if(i <= 1)
			return i;
		else
			return getFibonacciSequence(i - 1) + getFibonacciSequence(i - 2);
	}
}
