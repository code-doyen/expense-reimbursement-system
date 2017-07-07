package com.revature.day2;

public class ConditionalStatements {

	public static void main(String[] args) {
		switchCase();
	}
	
	static void switchCase(){
		int i = 10;
		switch(i){
		case 0:
			System.out.println("0");
			break;
		case 1:
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
			break;
		case 10:
			System.out.println("10");
			break;
		case 11:
			System.out.println("11");
			break;
		default:
			System.out.println("default");
			break;
		}
	}
}





