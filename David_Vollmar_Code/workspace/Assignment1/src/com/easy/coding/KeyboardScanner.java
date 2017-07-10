package com.easy.coding;

import java.util.Scanner;

public class KeyboardScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Input an int variable: ");
		System.out.println("int keyed: " + keyboard.nextInt());
		System.out.print("Input an double variable: ");
		System.out.println("Double keyed: " + keyboard.nextDouble());
		System.out.print("Input an String variable: ");
		System.out.println("String keyed: " + keyboard.next() + keyboard.nextLine());	
	}

}
