package com.val.programs;

import java.util.Scanner;
public class TestQueens 
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of queens:");
	    int n=sc.nextInt();
		Queen q=new Queen(n);
		q.canplaceQueen(0,n);
	}
}
