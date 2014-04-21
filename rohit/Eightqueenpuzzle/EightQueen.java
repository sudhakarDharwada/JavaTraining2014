package com.vl.arrayoperations;


public class EightQueen 
{
	static int size=8;
	public static int[] coordinates =new int[size];
	private static int sol=0;
	public boolean issafeposition(int x1,int y1,int x2,int y2)
	{
		if(x1==x2||y1==y2||Math.abs(x2-x1)==Math.abs(y2-y1))
			return false;
		return true;
	}
	public boolean put(int row)
	{
		boolean flag=false;
		int count=0;
		if(row==size)
		{
			sol++;
			System.out.print(sol+"--->");
			for(int p=0;p<8;p++)
				System.out.print("("+p+","+coordinates[p]+")");
			System.out.println();
		}
		else
		{
			for(int col=0;col<size&&!flag;col++)
			{
				count=0;
				for(int k=0;k<row;k++)
				{
					if(issafeposition(k,coordinates[k],row, col))
						count++;
				}
				if(count==row) 
				{
					coordinates[row]=col;
					flag=put(row+1);
				}
			}
		}
		return flag;
	}
	public static void main(String[] args)
	{
		EightQueen q=new EightQueen();
		q.put(0);
	}
}