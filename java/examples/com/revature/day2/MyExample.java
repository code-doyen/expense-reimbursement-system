package com.revature.day2;

public class MyExample {

	int i;
	float f;
	char c;
	double d;
	long l;
	short s;
	byte b;
	boolean boo;
	
	public static void main(String[] args) {
		MyExample m1 = new MyExample();
		//m1.printDefaultValues();
		//m1.myMethod();
	}
	void myMethod(){
		int i = 0;
		System.out.println("value of i in myMethod " + i);
	}
	void printDefaultValues(){
		MyExample m1 = new MyExample();
		System.out.println(m1.i);
		System.out.println(m1.c);
		System.out.println(m1.b);
		System.out.println(m1.d);
		System.out.println(m1.l);
		System.out.println(m1.boo);
		System.out.println(m1.s);
		System.out.println(m1.f);
	}
}
