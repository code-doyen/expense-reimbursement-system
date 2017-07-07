package com.revature.day2;

public class MultipleVariables {

	public static void main(String[] args) {
//		display(1);
//		display(2,10,20);
//		display(3,10,20,30);
//		display(4,10,20,30,40,50);
//		display(5,10,20,30,40,50,60,70);
//		display(6,10,20,30,40,50,60,70,80,90);
		
		//newDisplay(1,2,3,4,5,6);
	}
	
	//varargs
	//multiple args have to be at the end of parameters
	//can't have two varargs in the same method 
	static void display(int...x){

		for (int i: x){
			System.out.println(i);
		}
	}
	
	static void newDisplay(int j, int k, int l, int...x){

		System.out.println("newDisplay - 3 + m");
//		for (int i: x){
//			System.out.println(i);
//		}
	}
	
	static void newDisplay(int j, int...x){
		System.out.println("newDisplay - 1 + m");
//		for (int i: x){
//			System.out.println(i);
//		}
	}

}
