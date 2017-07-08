package com.oop;

public class Creation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		
		one.eat();
		one.move();
		one.walk();
		two.eat();
		two.move();
		two.walk();
		three.eat();
		three.move();
		three.walk();
	}
}
//For one this creates a compile time error because we never fulfilled the contract when we implemented 
//the Animal interface in mammal by not implementing a method move. Secondly, an error for the method walk is not defined in
//the Animal interface and causes a compile time error. Plus seems kinda pointless to be instantiating and interface that only contains
//method stubs.