package com.revature.day2;

public class Blocks {
	int i;
	static int value = 5; //1
	int nonStaticValue = 3; //3
	{
		System.out.println("3 - Nonstatic value: "+nonStaticValue);
		System.out.println("4 - Nonstatic block");
	}
	static { //2
		System.out.println("1 - Static value: "+value);
		System.out.println("2 - Static block");
	}
	public Blocks() { //4
		System.out.println("5 - Constructor - "+value); 
	}
	// If I don't create an instance, 1 and 2 get executed
	// When you instantiate, 3 and 4 get executed as well.
	// 1 - Static variables
	// 2 - Static blocks
	// 3 - Non Static Variables
	// 4 - Non Static Block
	// 5 - Constructor
	public static void main(String[] args) {
		//System.out.println(Blocks.value);
		//new Blocks();
		
		//int i;
		//System.out.println(i);
	}
}
