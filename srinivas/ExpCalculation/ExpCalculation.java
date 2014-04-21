package com.exp;

import java.util.Scanner;
import java.util.Stack;

public class ExpCalculation{


	static Stack<Integer> values = new Stack<Integer>();
	static Stack<Character> opr=new Stack<Character>();


	public static void main(String args[])throws NullPointerException
	{	
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Expression ");

		String exp=sc.next();


		calculation(exp);

		result();

	}


	static Stack<Integer> methodCal(char c,Stack<Integer> opr)
	{

		switch(c)
		{
		case '*':
			opr.push(opr.pop()*opr.pop());
			break;
		case '/':
			opr.push(opr.pop()/opr.pop());
			break;
		case '+':
			opr.push(opr.pop()+opr.pop());
			break;
		case '-':
			opr.push(opr.pop()-opr.pop());
			break;
		}
		return opr;
	}




	private static void result() {

		System.out.println("Result is:"+values.pop());


	}


	private static void calculation(String exp) {

		boolean priority=false;	
		for(int i=0;i<exp.length();i++)
		{
			char ch=exp.charAt(i);


			switch(ch)
			{
			case '*': 

				priority=false;
				opr.push(ch);
				break;

			case '/':
				priority=false;
				opr.push(ch);

				break;

			case '+':
				if(priority==true){
					values=methodCal(opr.pop(),values);
				}
				else
					opr.push(ch);
				break;

			case '-':
				if(priority==true){
					
					values=methodCal(opr.pop(),values);
				}
				else
					opr.push(ch);	
				break;

			case '(': 
				opr.push(ch);
				break;

			case ')':
				while(!opr.isEmpty() && !opr.peek().equals(")")){
					char res=opr.pop();
					if(res!= '(')
						values=methodCal(res,values);
				}
				break;

			default: values.push(ch - '0');	
			break;
			}
		}

		while(!opr.isEmpty()){

			values=methodCal(opr.pop(),values);
		}
	}
}	

