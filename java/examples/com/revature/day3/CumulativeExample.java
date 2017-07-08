package com.revature.day3;

import com.revature.day3.oop.Player;

/*class, method, variable

public - can be accessed within class, within a package, within project, whole world
private	- can only be accessed within the class
protected - can be accessed within a class, package and subclass
default - can be accessed within class and package*/

public class CumulativeExample extends Player {

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

	void testMethod(){
		CumulativeExample p1 = new CumulativeExample();
		p1.medals();
	}
	
	
	
}
