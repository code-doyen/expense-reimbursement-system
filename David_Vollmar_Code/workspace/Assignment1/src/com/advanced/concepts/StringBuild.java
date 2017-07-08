package com.advanced.concepts;

public class StringBuild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("Making a string");
		
		System.out.println(sb.deleteCharAt(7));
		System.out.println(sb.insert(7, ":"));
		System.out.println(sb.reverse());
	}

}
