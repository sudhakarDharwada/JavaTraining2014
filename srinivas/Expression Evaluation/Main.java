package com.exp;

import java.util.Scanner;
import java.util.Stack;

public class Main{

	static Stack<Character> opr = new Stack<Character>();
	static Stack<Integer> oprd = new Stack<Integer>();

	public static void main(String[] args) throws Exception{

		Scanner s = new Scanner(System.in);

		System.out.println("Ener exp:");
		String exp = s.next();


		StirngToStacks(exp);

		evaluating();

		display();


	}



	private static void display() {

		System.out.println("The final value is :");
		while(!oprd.isEmpty()){
			System.out.println(oprd.pop());
		}

	}



	private static void evaluating() {

		while(!opr.isEmpty()){

			int var1 = oprd.pop();
			int var2 = oprd.pop();

			System.out.println(var1 +" "+var2);
			char operation = opr.pop();
			System.out.println(operation);
			int result =0;

			switch(operation){

			case '+': 
				result = var1+var2;
				break;
			case '-': 
				result = var2-var1;
				
				break;
			case '*': 
				result = var1*var2;
				
				break;
			case '/': 
				result = var1/var2;
				
				break;

			default : 
				
				throw new IllegalArgumentException("Illegal operation");

			}
			oprd.push(result);
		}

	}



	public static  void  StirngToStacks(String s)   

	{
		int i=0;
		while(i<s.length()){

			char ss = s.charAt(i);

			if(ss=='+' || ss=='-' || ss =='*' || ss=='/' || ss ==')' || ss ==')'){


				if( ss == '+' || ss =='-'){
					
					Main.evaluating();
					
					
				}
				opr.push(ss);

			}else{

				int myInt = ss -'0';
				oprd.push(myInt);
				//evaluating();
				
			}


			i++;
		}

	}

}
