package com.advanced.exercises;

public class NumsOneToFifty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i =1; i <= 50; i++){
			if(i%3 == 0)
				System.out.println("Fizz");
			if(i%5 ==0)
				System.out.println("Buzz");
			if(i%3 == 0 && i%5 ==0)
				System.out.println("FizzBuzz");
			
		}
	}

}
