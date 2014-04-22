

import java.util.Scanner;

public class DigitToText {
	void digitTotext(int temp)
	{
		switch(temp)
		{
		case 1:System.out.print("one ");
		       break;
		case 2:System.out.print("two ");
		       break;
		case 3:System.out.print("three ");
		       break;
		case 4:System.out.print("four ");
			   break;
		case 5:System.out.print("five ");
		       break;
		case 6:System.out.print("six ");
		       break;
		case 7:System.out.print("seven ");
		       break;
		case 8:System.out.print("eight ");
		       break;
		case 9:System.out.print("nine ");
		       break;
		case 10:System.out.print("ten ");
		       break;
		case 11:System.out.print("eleven ");
		       break;
		case 12:System.out.print("twelve ");
	           break;
	    case 13:System.out.print("thirteen ");
	           break;
	    case 14:System.out.print("fourteen ");
		       break;
	    case 15:System.out.print("fifteen ");
	           break;
	    case 16:System.out.print("sixteen ");
	           break;
	    case 17:System.out.print("seveneen ");
	           break;
	    case 18:System.out.print("eighteen ");
	           break;
	    case 19:System.out.print("nineteen ");
	           break;
	    case 20:System.out.print("twenty ");
	           break; 
	    case 30:System.out.print("thirty ");
	           break;
	    case 40:System.out.print("fourty ");
	           break;
	    case 50:System.out.print("fifty ");
	           break;
	    case 60:System.out.print("sixty ");
	           break;
	    case 70:System.out.print("seventy ");
	           break;
	    case 80:System.out.print("eighty ");
	           break;
	    case 90:System.out.print("ninty ");
	           break;
	    case 100:System.out.print("hundredend ");
	           break;
	    case 1000:System.out.print("thousand ");
	           break;
	    case 100000:System.out.print("lakh ");
	           break;
	           
		}
	}
	void digit(int number)
	{
		int temp;
		if(number==0)
		System.out.print("Zero");
		if(number>=100000)
		{
		   temp=number/100000;
		   if(temp<=20)
		   digitTotext(temp);
		   else
		   {
			   digitTotext(temp/10*10);
			   digitTotext(temp%10);
		   }
		   digitTotext(100000);
		   number=number%100000;   
		}
		if(number>=1000)
		{
		   temp=number/1000;
		   if(temp<=20)
		   digitTotext(temp);
		   else
		   {
			   digitTotext(temp/10*10);
			   digitTotext(temp%10);
		   }
		   digitTotext(1000);
		   number=number%1000;   
		}
		if(number>=100)
		{
			temp=number/100;
			digitTotext(temp);
			digitTotext(100);
			number=number%100;
		}
		if(number<=20)
			digitTotext(number);
		else
		{
			digitTotext(number/10*10);
			digitTotext(number%10);
		}
				
	}
	public static void main(String args[])
	{
		DigitToText dtt=new DigitToText();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the value of number");
		int number =sc.nextInt();
		dtt.digit(587);
	}

}
