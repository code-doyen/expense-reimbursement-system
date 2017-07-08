package com.advanced.concepts;

public class GarbageCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		invokeTrashCollector();
	}
	public static void invokeTrashCollector(){
		System.gc(); // num, num, num
		System.out.println("Garbage Cleaned Up!");
	}
}
