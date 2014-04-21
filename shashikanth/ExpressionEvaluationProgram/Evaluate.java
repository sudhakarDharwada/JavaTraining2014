package com.val.programs;

import java.util.Stack;
import java.util.StringTokenizer;

public class Evaluate 
{
	public static int getResult(String s) throws Exception 
	{
		Stack<Integer> operands=new Stack<Integer>();
		Stack<String> operators=new Stack<String>();
		StringTokenizer str=new StringTokenizer(s," ");
		String token=null;
		while(str.hasMoreTokens())
		{
			token=str.nextToken();
			if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/"))
			{
				 if(!operators.empty() && checkPrecedence(token, operators.peek()))
	             {
	                operands.push(applyOperation(operators.pop(), operands.pop(), operands.pop()));
	             }
				 operators.push(token);
			}
			else
			{
				operands.push(Integer.parseInt(token));
			}
		}
		while(!operators.empty())
	    {
	        operands.push(applyOperation(operators.pop(), operands.pop(), operands.pop()));
	    }
	    return operands.pop();
	}

	private static int applyOperation(String c, Integer a,Integer b) throws Exception
	{
		if(c.equals("+"))
		{
			if(a>b)
			{
			  return (a+b);
			}
			else
				return (b+a);
		}
		else if(c.equals("-"))
		{
			if(a>b)
			  return (a-b);
			else
			  return (b-a);
		}
		else if(c.equals("*"))
		{
			  return (a*b);
		}
		else if(c.equals("/"))
		{
			if(b==0)
			{
				throw new Exception("Can't divide by zero");
			}
			return (a/b);
		}
		return 0;
	}

	private static boolean checkPrecedence(String string, String string2) 
	{
		if ((string.equals("*") || string.equals("/")) && (string2.equals("+") || string2.equals("-")))
            return false;
        else
            return true;
	}
}
