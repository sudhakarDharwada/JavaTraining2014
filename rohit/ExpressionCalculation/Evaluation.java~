package com.vl.stackoperations;

import java.util.Scanner;

public class Evaluation 
{
	public Stack calculate(Stack s) throws Myownexception
	{
		int z=0;
		int x=s.pop(s.operand);
		int y=s.pop(s.operand);
		char ch1=s.pop(s.operator);
		switch(ch1)
		{
			case '+':
				z=x+y;
				break;
			case '*':
				z=x*y;
				break;
			case '/':
				z=y/x;
				break;
			case '-':
				z=y-x;
				break;
			default:
				throw new Myownexception();
		}
		s.push(z);
		return s;
	}
	public Stack readstack(String expression) throws Myownexception
	{
		int size=expression.length();
		Evaluation e1=new Evaluation();
		Stack s=new Stack(size);
		boolean ishighprecedence=false;
		for(int i=0;i<size;i++)
		{
			char ch=expression.charAt(i);
			if(ch>='0'&&ch<='9')
			{
				s.push((int)(ch-'0'));
				if((ishighprecedence))
				{
					e1.calculate(s);
				}
			}
			else
			{
				s.push(ch);
				if(ch==')')
				{
					s.pop(s.operator);
					for(int k=s.pointer2;s.operator[k]!='(';k--)
					e1.calculate(s);
					s.pop(s.operator);
					if(s.operator[s.pointer2]=='*'||s.operator[s.pointer2]=='/')
						e1.calculate(s);
				}
				ishighprecedence=false;
				if(ch=='*'||ch=='/')
					ishighprecedence=true;
			}
		}
		return s;
	}
	public static void main(String[] args) throws Myownexception 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter expression to evaluate :");
		String ex=sc.next();
		Evaluation e=new Evaluation();
		Stack s1=e.readstack(ex);
		while(s1.pointer2>=0)
		{
			s1=e.calculate(s1);
		}
		System.out.println("result  :"+s1.pop(s1.operand));
	}
}
class Myownexception extends Exception
{
	public Myownexception()
	{
		System.out.println("not an expression");
	}
}
