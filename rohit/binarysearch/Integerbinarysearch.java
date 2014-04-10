package com.vl.searching;

import java.util.Scanner;
import java.util.Arrays;

public class Integerbinarysearch 
{	
	public boolean isfound(int[] input,int key)
	{
		int first,last,middle;		
		boolean flag=false;
		Arrays.sort(input);
		first=0;
		last=input.length-1;
		while(first<=last)
		{
			middle=(first+last)/2;
			if(input[middle]<key)
				first=middle+1;
			else if(input[middle]==key)
			{
				flag=true;
				break;
			}
			else 
				last=middle-1;
		}
		return flag;		
	}

	public static void main(String[] args) 
	{
		int search_key,size;
		Scanner sc= new Scanner(System.in);
		System.out.println("enter size :");
		size=sc.nextInt();
		int[] input = new int[size];
		System.out.println("enter input elements :");
		for(int i=0;i<size;i++)
		{
			input[i]=sc.nextInt();
		}
		System.out.println("enter the key elemant :");
		search_key=sc.nextInt();
		Bsearch bs = new Bsearch();
		if(bs.isfound(input,search_key,size))
			System.out.println("element found");
		else
			System.out.println("element not found");

	}

}

