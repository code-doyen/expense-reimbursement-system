package com.exceptions;

public class ThrowException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			System.out.println("Starting try block");
			System.exit(0);
			seeException();
			System.out.println("Starting ending block");
		}catch(CustomException e){
			System.out.println("Starting catch block");
			System.out.println(e.getMessage());
			System.out.println("Starting catch block");
		}finally{
			System.out.println("Goodbye");//Yup still ran before executable exited.
		}
	}
	public static void seeException() throws CustomException{
		throw new CustomException();
	}

}
