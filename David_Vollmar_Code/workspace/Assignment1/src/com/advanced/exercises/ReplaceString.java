package com.advanced.exercises;

public class ReplaceString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String phrase ="The cat in the cat";
		System.out.println(replaceStringAtPosition(phrase,'c', 'b'));
	}
	public static String replaceStringAtPosition(String s, char oldChar,char newChar){ 
		return s.replace(oldChar, newChar);
	}
}
