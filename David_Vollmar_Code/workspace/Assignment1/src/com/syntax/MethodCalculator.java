package com.syntax;

public class MethodCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 20, num2 = 10;
		System.out.println(add(num1, num2));
		System.out.println(subtract(num1, num2));
		System.out.println(divide(num1, num2));
		System.out.println(multiply(num1, num2));

	}
	static int add(int a, int b){
		return a+b;
	}
	static int subtract(int a, int b){
		return a-b;
	}
	static int divide(int a, int b){
		return a/b;
	}
	static int multiply(int a, int b){
		return a*b;
	}

}
