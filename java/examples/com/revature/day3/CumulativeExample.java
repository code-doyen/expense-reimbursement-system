package com.revature.day3;

public class CumulativeExample {

	private int i;

	public static void main(String[] args) {
		int i = 10;
		//Integer newvariable = new Integer(i);	//primitive to wrapper
		Integer newVariable = i;
		
		System.out.println(i);				//10
		System.out.println(newVariable);	//10
		
		//Object
		
		System.out.println(new CumulativeExample()); 	//
		System.out.println(new CumulativeExample().hashCode()); 	//
		System.out.println(new CumulativeExample().toString()); 	//
	}

	
	
}
