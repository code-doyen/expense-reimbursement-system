package com.advanced.excercises;

import java.util.Calendar;
import java.util.Scanner;

public class CalenderObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Calendar birthdate  = Calendar.getInstance();
		System.out.println("Enter month born: ");
		Scanner keyboard = new Scanner(System.in);
		int month = keyboard.nextInt() - 1;
		System.out.println("Enter day born: ");
		int day = keyboard.nextInt();
		System.out.println("Enter year born: ");
		int year = keyboard.nextInt();
		System.out.println("You are: " + getAge(getBirthdayObject(year, month, day)));
		
		keyboard.close();
		//System.out.println(today.get(Calendar.MONTH)); // off by index 1
		//System.out.println(today.get(Calendar.DATE));
		//System.out.println(today.get(Calendar.YEAR));
		
		
		
	}
	public static int getAge(Calendar b){
		Calendar today  = Calendar.getInstance();
		if(today.get(Calendar.DATE)- b.get(Calendar.DATE) != 0)
			return today.get(Calendar.YEAR)- b.get(Calendar.YEAR) - 1;
		else{
			System.out.println("Happy Birthday Song!");
			return today.get(Calendar.YEAR)- b.get(Calendar.YEAR);
		}
	}
	public static Calendar getBirthdayObject(int year, int month, int date){
		Calendar calendar =  Calendar.getInstance();
		calendar.set(year, month, date);
		return calendar;
	}
}
