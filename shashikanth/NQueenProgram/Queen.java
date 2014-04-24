package com.val.programs;

class Queen
{
	static int arr[];static int count=0;
	Queen(int x)
	{
		arr=new int[x];
	}
	private static boolean isSafePosition(int x2,int y2) 
	{
		for(int j=0;j<x2;j++)
		{
			int x1=j;int y1=arr[j];
			if((x1==x2)||(y1==y2)||(Math.abs(x2-x1)==Math.abs(y2-y1)))
			{
				return false;
			}
		}
			return true;
	}
	public void canplaceQueen(int r,int n) 
	{	
		for(int c=0;c<arr.length;c++)
		{
			if(isSafePosition(r,c))
			{
				arr[r]=c;
				canplaceQueen(r+1, n);
			}	
		}
		if(r==n)
		{
			count++;
			printQueens(arr);
		}
	}
	private void printQueens(int[] arr2) 
	{
		System.out.print(count+"==>");
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				if(arr[i]==j)
				{
					System.out.print("("+i+","+j+")");
				}
			}
		}
		System.out.println();
	}
		
}