package com.revature.day2;

public class ConstructorExample {

	int x, y;		//object scope
	
	//no-args constructors
	public ConstructorExample() {
		System.out.println("no-arg constructor");
	}
	
	{
		System.out.println("non-static block");
	}
	
	public ConstructorExample(int x){
		System.out.println("value of x : " + x);
	}
	
	public ConstructorExample(int x, int y){
		System.out.println("value of x : " + x + "value of y : " + y);	
	}
	
	public ConstructorExample(String s, int y){
		System.out.println("value of x : " + s + " value of y : " + y);	
	}
	
	public ConstructorExample(int y, String s){
		System.out.println("value of x : " + s + " value of x : " + y);	
	}
	
/*	public ConstructorExample(int y, int x){
		System.out.println("value of x : " + x + "value of y : " + y);	
	}*/
	
	public static void main(String[] args) {
		testMethod();
		new ConstructorExample();
		/*		new ConstructorExample(100);
		new ConstructorExample(10, 20);
		
		new ConstructorExample(40, "string value after int");
		new ConstructorExample("string value before ", 50);*/
	}
	
	static void testMethod(){
		System.out.println("testMethod");
	}

}







