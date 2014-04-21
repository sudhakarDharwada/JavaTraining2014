package com.prime;

import java.util.Scanner;

/*this method checks whether the number is prime or not and their difference is equals to 2*/
public class Primefinder {
	/*This method checks the condition that two numbers are prime and their difference is equals to 2*/
	public boolean mainLogic(int first,int second)
	{
		if(((first-second)==2)||((first-second==-2))){
			if((isPrime(first)&&(isPrime(second))))
			{
				return true;
			}
			else {
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	/*This method checks the is prime or not*/
	public boolean isPrime(int number)
	{
		boolean returnStatus=false;
		for(int i=2;i<Math.sqrt(number);i++)
		{
			if(((number%i))==0)
			{
				returnStatus=false;
			}
			else {
				returnStatus =true;
			}
		}
		return returnStatus;
	}
	public static void main(String[] args) {
		System.out.println("Enter The Two Numbers");
		Scanner s=new Scanner(System.in);
		int first=s.nextInt();
		int second=s.nextInt();
		Primefinder pf=new Primefinder();
		if(pf.mainLogic(first, second))
		{
			System.out.println("It satisfied the condition");
		}
		else {
			System.out.println("It dont satisfied the condition");
		}

	}

}

