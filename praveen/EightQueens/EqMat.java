package com.eightqueen.test.bean;

public class EqMat {
	public static int[] intialize(int n)
	{
		int matrix[] =new int[n];
		for(int i=0;i<n;i++)
		{
			matrix[i]=0;
		}
		return matrix;
	}
	private static void outArray(int[] mat) {
		for(int i=0;i<8;i++)
			System.out.println("The position "+(i)+" "+mat[i]);
	}
}
