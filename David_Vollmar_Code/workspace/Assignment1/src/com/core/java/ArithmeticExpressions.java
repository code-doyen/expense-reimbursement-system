package com.core.java;

public class ArithmeticExpressions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 20, num2 = 10;
		add(num1, num2);
		subtract(num1, num2);
		divide(num1, num2);
		multiply(num1, num2);

	}
	static void add(int a, int b){
		System.out.println(a+b);
	}
	static void subtract(int a, int b){
		System.out.println(a-b);
	}
	static void divide(int a, int b){
		System.out.println(a/b);
	}
	static void multiply(int a, int b){
		System.out.println(a*b);
	}
}
