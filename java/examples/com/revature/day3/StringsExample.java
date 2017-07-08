package com.revature.day3;

import java.util.StringTokenizer;

public class StringsExample {

	public static void main(String[] args) {
		//myString();
		//strBuff();
		testStr();
	}

	static void myString() {
		String s1 = "My daughter is willing to teach guitar after buying her toy";
		String s2 = "My daughter is willing to teach guitar after buying her toy";
		String s3 = new String("My daughter is willing to teach guitar after buying her toy");

		if (s1 == s2) {
			System.out.println("==s1, s2 are equal");
		} else
			System.out.println("==s1 and s2 are not equal");

		if (s2 == s3) {
			System.out.println("==equal");
		} else
			System.out.println("==s3 and s2 are not equal");

		if (s1.equals(s2) || s2.equals(s3)) {
			if (s1.equals(s2)) {
				System.out.println("s1 equals s2");
			} else
				System.out.println("s1 not equals s2");
			if (s2.equals(s3)) {
				System.out.println("s3 equals s2");
			} else
				System.out.println("s3 not equals s2");
		}

		long starttime1 = System.nanoTime();
		
		for (int i = 0; i < 10000; i++) {
			String s4 = "hello";
		}
		
		long endtime1 = System.nanoTime();
		long totaltime1 = endtime1 - starttime1;
		System.out.println(totaltime1);
		
		long starttime2 = System.nanoTime();
		
		for (int i = 0; i < 10000; i++) {
			String s5 = new String("hello");
		}
		long endtime2 = System.nanoTime();
		long totaltime2 = endtime2 - starttime2;
		System.out.println(totaltime2);
	}

	static void strBuff() {
		StringBuffer s1 = new StringBuffer();
		s1.append("this is sample string buffer");

		System.out.println(s1);
	}
	
	static void testStr(){
		String s3 = new String("hello");
		String s1 = "hello";
		String s2 = "hello";
		
		//Object
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s1.equals(s2));		//true
		System.out.println(s1.equals(s3));		//true
	}
	
	void myStringToken(){
		String s3 = "I want to split my strings based on a delimiter space";
		StringTokenizer strToken = new StringTokenizer(s3, "a");
		System.out.println("first " + strToken.nextToken("o"));
		while (strToken.hasMoreTokens()){
			System.out.println("more " + strToken.nextToken());
		}
	}

}









