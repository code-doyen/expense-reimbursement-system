package com.core.java;

public class ShortCircuitOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numbers[] = {80,120,190};
		if(numbers[0]>numbers[1] && numbers[0] > numbers[2])
			System.out.println("Greatest number is " + numbers[0]);
		else if(numbers[1]>numbers[0] && numbers[1] > numbers[2])
			System.out.println("Greatest number is " + numbers[1]);
		else
			System.out.println("Greatest number is " + numbers[2]);
	}

}
