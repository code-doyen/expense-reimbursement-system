package com.syntax;

public class MethodCalcClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 20, num2 = 10;
		Operators op = new Operators();
		//Operations op = new Operations();
		System.out.println(op.add(num1, num2));
		System.out.println(op.subtract(num1, num2));
		System.out.println(op.divide(num1, num2));
		System.out.println(op.multiply(num1, num2));

	}
	//nested class
	/*static class Operations {
		public Operations() {
		}
		public int add(int a, int b){
			return a+b;
		}
		public int subtract(int a, int b){
			return a-b;
		}
		public int divide(int a, int b){
			return a/b;
		}
		public int multiply(int a, int b){
			return a*b;
		}

	}
	*/
}
