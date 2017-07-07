package com.revature.day2;

public class LoopsExample {
//throw away code - used for debugging
//	int x = 10;
//	static int y = 10;
	public static void main(String[] args) {
//		LoopsExample L1 = new LoopsExample();
//		System.out.println(++(L1.x));	//11
//		System.out.println(++y);		//11
//		L1.forLoop();
		//whileLoop();
		//doWhileLoop();
		enhancedForLoop();
	}
	
	static void forLoop(){
		for(int i=0; i<10; i++){
			System.out.println("value of i " + i);
		}
	}
	
	static void whileLoop(){
		int i = 0;
		while(true){
			i++;
			System.out.println("value of i " + i);
			if (i == 10){
				break;
			}
		}
	}
	
	static void doWhileLoop(){
		int i = 0;
		do{
			i++;
			if(i == 4) continue;
			System.out.println("value of i " + i);
		} while (i < 10);
	}
	
	static void enhancedForLoop(){
		int i [] = {1,2,3,4,5};
		int [] j = new int [10];
		j[0] = 1;
		j[1] = 2;
		
		for (int x:i){
			System.out.println(x);
		}
		
		for (int x:j){
			System.out.println(x);
		}
		
		for (int x=0; x<i.length; x++){
			System.out.println("using length " + i[x]);
		}
	}
}








