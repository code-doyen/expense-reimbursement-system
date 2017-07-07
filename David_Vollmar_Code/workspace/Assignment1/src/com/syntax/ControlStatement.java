package com.syntax;

public class ControlStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//selection statements
		int num = 23;
		int sentinel = 0;
		int nums[] ={1, 3, 5, 7, 9};
		if(num > 20)
			System.out.println(num +" is greater than 20");
		else if(num < 20)
			System.out.println(num +" is less than 20");
		else
			System.out.println(num +" is equivalent to 20");
		switch(num){
			case 12:
				System.out.println("Case is a 12");
				break;
			case 10:
				System.out.println("Case is a 10");
				break;
			case 23:
				System.out.println("Case is a 23");
				break;
			default:
				System.out.println("Case is defaulted");
				break;
		}
		
		//loop statements
		
		while(sentinel < 5){
			sentinel++;
				if(sentinel == 3){
					System.out.println("\nskipped iteration");
					continue;//transfer statement
				}	
			System.out.println("\nwhile iteration: " + sentinel);	
		}
		
		sentinel = 0;
		do{
			++sentinel;
			if(sentinel>3){
				System.out.println("\ndo-while iteration: " + add(sentinel));
			}
			else
				System.out.println("\ndo-while iteration: " + sentinel);
		}while(sentinel < 5);
		
		for(int i = 0; i < sentinel; i++){
			System.out.println("\nfor iteration: " + i);
			if(i >= 3){
				System.out.println("\nbroke loop");
				break;//transfer statement
			}
		}
		
		for(int i:nums)
			System.out.println("\nEnhanced for iteration: " + i);
	}
	static int add(int b){
		return b+1;	//transfer statement
	}
}
