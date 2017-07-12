package com.advanced.excercises;

import java.util.Scanner;

public class IsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter a number and I'll tell you whether it is prime: ");
		Scanner s = new Scanner(System.in);
		isPrime(s.nextInt());
	}
	public static void isPrime(int num){
		boolean divisorFound = false;
		int div = 1;   
		while(div < (num - 1) && !divisorFound){
			div++;
			if ((num % div) == 0)
				divisorFound = true;
		}
		if (divisorFound)
			System.out.println(num + " is not a prime number.");
		else
		   System.out.println(num + " is a prime number.");	
	}

}
