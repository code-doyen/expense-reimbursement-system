package com.bonus.exercises;

import java.util.Random;
import java.util.Scanner;

public class NumberGuess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random randG = new Random();
		int randNum = randG.nextInt(100);
		Scanner keyboard = new Scanner(System.in);
		int guess = -1;
		int trys = 0;
		System.out.println("Guess a number\nBetween (0-99)?");
		while(guess != randNum){
			if(trys != 0)
				System.out.println("Try Again!");
			trys++;
			guess = keyboard.nextInt();
			if(guess > randNum){
				System.out.println("Try lower!");
			}
			else if(guess < randNum){
				System.out.println("Try higher!");
			}
			else
				System.out.println("You got it in "+trys+" trials!");
						
		}
		keyboard.close();
	}

}
