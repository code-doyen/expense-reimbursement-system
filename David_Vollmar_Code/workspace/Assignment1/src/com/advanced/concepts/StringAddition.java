package com.advanced.concepts;

public class StringAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "20", s2 = "20";
		System.out.println(addStrings(s1,s2));
	}
	public static Integer addStrings(String s1, String s2){
		return Integer.parseInt(s1) + Integer.parseInt(s2);
	}
}
