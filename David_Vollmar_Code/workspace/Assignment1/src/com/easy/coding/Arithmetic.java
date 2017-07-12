package com.easy.coding;

public class Arithmetic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(args[1]);
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		String operator = args[2];
		if(operator.equals("+"))
			System.out.println(num1 +"+"+ num2+"="+(num1 + num2));
		else if(operator.equals("-"))
			System.out.println(num1 +"-"+ num2+"="+(num1 - num2));
		else if(operator.equals("/")){
			if(num2 == 0)
				System.out.println(num1 +"/"+ num2+"=0");
			else
				System.out.println(num1 +"/"+ num2+"="+(num1 / num2));
		}
		else if(operator.equals("x")) // * is a wild card for the command line and therefore does not work..
			System.out.println(num1 +"*"+ num2+"="+(num1 * num2));
		else
			System.out.println("Invalid operand");
	}

}
