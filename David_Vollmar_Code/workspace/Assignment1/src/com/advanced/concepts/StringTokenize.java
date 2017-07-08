package com.advanced.concepts;

import java.util.StringTokenizer;

public class StringTokenize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringTokenizer	st = new StringTokenizer("pickes:ketchup:mustard:onion", ":");//string / delimiter
		while(st.hasMoreTokens())
			System.out.println(st.nextToken());
	}

}
