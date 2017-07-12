package com.advanced.exercises;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "dog";
		System.out.println(reverseString(s));
	}
	public static String reverseString(String s){
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	}

}
