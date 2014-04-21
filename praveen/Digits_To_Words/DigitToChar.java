package com.digit;

import java.util.Scanner;

/*This Program prints the given number from digit format to word format*/
public class DigitToChar {
	private String Number[]={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eightteen","NineTeen","","","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninty"};
	/* This Method Counts the Number of Digits*/
	public long digitCount(long number)
	{
		long count=0;
		while(number>0)
		{
			count++;
			number=number/10;
		}
		return count;
	}
        /*this method changes calculate the place value of the digit*/
	public void mainLogic(long number)
	{
		long reqiuredDigit;
		
		if(((digitCount(number))<20)&&((digitCount(number))>9))
		{
			reqiuredDigit=number/10000000;
			System.out.println(digitCount(number));
			mainLogic(reqiuredDigit);
			number=number%10000000;
			System.out.print("crores ");
			if(number==0)
			{
				System.out.print("");
			}
			else{
				mainLogic(number);
			}
		}else if(((digitCount(number))==8)||((digitCount(number))==9))
		{
			reqiuredDigit=number/10000000;
			printWord(reqiuredDigit, "crores");
			number=number%10000000;
			mainLogic(number);
		}else if(((digitCount(number))==7)||(digitCount(number))==6)
		{
			reqiuredDigit=number/100000;
			printWord(reqiuredDigit, "Lakhs");
			number=number%100000;
			mainLogic(number);
		}else if(((digitCount(number))==5)||((digitCount(number))==4))
		{
			reqiuredDigit=number/1000;
			printWord(reqiuredDigit, "Thousand");
			number=number%1000;
			mainLogic(number);
		}else if((digitCount(number))==3)
		{
			reqiuredDigit=number/100;
			printWord(reqiuredDigit, "Hundread And");
			number=number%100;
			mainLogic(number);
		}else if(((digitCount(number))==2)||((digitCount(number))==1))
		{
			printWord(number, "");
		}
	}
        /*This method print the word*/
	public void printWord(long reqiuredDigit,String string)
	{
		int tensDigit;
		int unitDigit;
		String word;
		if(reqiuredDigit<20)
		{
			word=belowTwenty(reqiuredDigit);
			System.out.print(word+" ");
			System.out.print(" "+string+" ");
		}
		else {
			tensDigit=(int) (reqiuredDigit/10);
			unitDigit=(int) (reqiuredDigit%10);
			tensDigit=tensDigit+20;
			word=belowTwenty(tensDigit);
			System.out.print(word+" ");
			word=belowTwenty(unitDigit);
			System.out.print(word+" ");
			System.out.print(" "+string+" ");
		}
	}
        /*This method can handles the numbers below 20*/
	public String belowTwenty(long reqiuredDigit)
	{
		
		String word="";
		word=Number[(int) reqiuredDigit];
		return word;
	}
        /*main method*/
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		DigitToChar dt=new DigitToChar();
		System.out.println("Enter the Number:");
		long number=0;
		try {
			number = s.nextLong();
		} catch (Exception e) {
			System.out.println("Sorry try again....!");
			System.out.println("Enter The Number with digits in between 1 to 19");
			System.exit(0);
		}
		if(number!=0){
			dt.mainLogic(number);
		}
		else {
			System.out.println("Sorry try again");
			System.out.println("Enter The Number with digits in between 1 to 19");
		}
	}

}
