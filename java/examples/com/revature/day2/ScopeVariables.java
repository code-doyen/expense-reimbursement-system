package com.revature.day2;
public class ScopeVariables {
	
	int instanceVariable = 10;	//object scope
	static int staticVariable = 10;		//class scope
	
	public static void main(String[] args) {
		ScopeVariables s1 = new ScopeVariables();
		s1.instanceVariable++;	//
		System.out.println(s1.instanceVariable);	//11
		staticVariable++;
		System.out.println(staticVariable);			//11
		//myMethod(40);
		s1.myMethod2();
	}
	
	public static void myMethod(int anotherLocalVariable){
		int localVariable1 = 10;		//method scope
		ScopeVariables s1 = new ScopeVariables();
		s1.instanceVariable++;
		System.out.println(s1.instanceVariable);		//11
		staticVariable++;
		System.out.println(staticVariable);				//12
		
		for (int i=10; i<20; i++){
			int localVariable2 = 10;		//block scope
			System.out.println(localVariable2+i);	//10 
			System.out.println(localVariable1);
		}
		
	}
	
	public void myMethod2(){
		//ScopeVariables s1 = new ScopeVariables();
		instanceVariable++;
		System.out.println(instanceVariable);			//12
		staticVariable++;
		System.out.println(staticVariable);				//12
	}
	

	
	
}
