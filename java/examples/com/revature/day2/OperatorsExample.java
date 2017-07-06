package com.revature.day2;
public class OperatorsExample {

	public static void main(String[] args) {
		//new OperatorsExample().arithmeticOperators();
		//new OperatorsExample().booleanOperators();
		new OperatorsExample().ternaryOperators();
	}

	void arithmeticOperators(){
		int x = 10, y = 20, z;
		System.out.println((x+y));	//30
		System.out.println((x-y));	//-10
		System.out.println((x/y));	//0
		System.out.println((x%y));	//10
		System.out.println((x*y));	//200
		
		//10
		System.out.println(x++);	//10
		System.out.println(x++);	//11
		System.out.println(++x);	//13
		System.out.println(x++);	//13
		System.out.println(x++);	//14
		System.out.println(++x);	//16
		System.out.println(x++);	//16
		///17
		System.out.println(x--);	//17
		System.out.println(--x);	//15
		System.out.println(--x);	//14
		System.out.println(x--);	//14
		System.out.println(x--);	//13
		System.out.println(++x);	//13
		System.out.println(++x);	//14
		System.out.println(x++);	//14
	
		x = x + 1;					//16
		x+=1;						//17
		x+=x;	//the value of x is doubled		34 
		System.out.println(x+=5);			//39
		System.out.println(x);				//39
		
	}	
	
	void relationalOperators(){
		int a = 10, b = 20;
		System.out.println((a==b));		//false
		//System.out.println((a==(b-=10)));		//true
		System.out.println((a!=b));		//true
		System.out.println((a>b));		//false
		System.out.println((a<b));		//true
		System.out.println((a>=b));		//false
		System.out.println((a<=b));		//true
	}
	
	void booleanOperators(){
		boolean a = true, b = false, c = false;
		int x = 10;
		System.out.println((a & b));		//false
		System.out.println((c & b));		//
		System.out.println((a | b));		//true
		System.out.println((a && b));		//false
		System.out.println((a || b));		//true
		System.out.println(!(a == b));		//true
		System.out.println((a ^ b));		//true
		//System.out.println((x >> 1));		//
		System.out.println((x >> 2));		//2
		System.out.println(x);
		//System.out.println((x << 1));		//8
	}
	
	
	void ternaryOperators(){
		int x = 10;
		int y;
		y = (x < 10) ? 9 : 10; 
		System.out.println(y);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
