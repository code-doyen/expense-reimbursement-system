package com.easy.coding;

import java.util.Scanner;

public class GradesStatistics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grades[] = new int[10];
		Scanner keyboard = new Scanner(System.in);
		for(int pos = 0; pos < grades.length; pos++){
			System.out.print("Enter grade " +(pos+1) +": ");
			if(keyboard.hasNextInt()){
				grades[pos]=keyboard.nextInt();
				if(!(grades[pos] >=0 && grades[pos] <= 100)){
					System.out.print("Grades must be (0-100)% Re-");
					pos--;
				}
			}
			else{
				pos--;
				keyboard.next();
			}
		}
		System.out.println("Average grade: " + average(grades));
		System.out.println("Min recorded grade: " + minimum(grades));
		System.out.println("Max recorded grade: " + maximum(grades));
		System.out.println("Standard Deviation: " + standardDeviation(grades));
		keyboard.close();
	}
	public static int average(int grade[]){
		int answer =0;
		for(int pos = 0; pos < grade.length; pos++)
			answer += grade[pos];
		return answer / grade.length;
	}
	public static int minimum(int num[]){
		int answer = num[0];
		for(int pos = 0; pos < num.length; pos++){
			answer = Math.min(answer, num[pos]);
		}
		return answer;
	}
	public static int maximum(int num[]){
		int answer = num[0];
		for(int pos = 0; pos < num.length; pos++){
			answer = Math.max(answer, num[pos]);
		}
		return answer;
	}
	public static int standardDeviation(int num[]){
		int answer =0;
		int summation = 0;
		int sum =0;
		int mean = 0;
		for (int pos = 0; pos < num.length; pos++){
			sum += num[pos];
		}
		mean = sum / num.length;
		for (int pos = 0; pos < num.length; pos++){
			summation += Math.abs(num[pos] - mean) * Math.abs(num[pos] - mean);
		}	
		answer = (int)Math.sqrt(summation/ num.length);
		return answer;
	}
}
