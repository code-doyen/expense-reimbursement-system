package com.advanced.excercises;

import java.util.Scanner;

public class ArmStrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arm=0, a, d, no;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number to check if it is Amrstrong:");
		no = s.nextInt();
		d = no;
		while(no >0){
			a=no%10;
			no /= 10;
			arm += a*a*a;
		}
		if(arm==d)
			System.out.println("ArmStrong");
		else
			System.out.println("Not ArmStrong");
	}

}
