package com.eightqueen.test.programs;


public class Equeen {
	static int Matrix[] = new int[8];
	public static boolean yCondition(boolean ycon)
	{
		return ycon;
	}

	public void EqueenFinder() {
		boolean ycon = false;
		int i=0;
		while(i<8)
		{
			int count=0;
			for(int j=0;j<8;j++)
			{
				if(yCondition(ycon))
				{
					j=Matrix[i];
				}
				int condition=CheckCondition(Matrix, i, j);
				
				if (condition==8) {
					count++;
					break;
				}

				ycon=false;
			}
			if(count==0)
			{
				Matrix[i]=0;
				i=i-1; 
				if(Matrix[i]>=7)
				{
					Matrix[i]=0;
					i=i-1;
					Matrix[i]=Matrix[i]+1;
					ycon=true;
				}
				else {
					Matrix[i]=Matrix[i]+1;
					ycon=true;
				}
			} else {
				ycon=false;
				i++;
			}

		}
		
	}

	public static int CheckCondition(int matix[],int x,int y) {
		int result=0;
			System.out.println("x:"+x+" y:"+y);
			int count=0;
			for(int i=x;i>=0;i--)
			{
				
				System.out.println("\t i:"+i);
				if(isSafeToPalce(i, matix[i], x,y))
				{
				
				
					count++;
					if(Matrix[0]==0){
						System.out.println("true");
						Matrix[x]=y;
					}
					System.out.println("x1:"+i+" y1:"+Matrix[i]+" x2:"+x+" y2:"+y);
				}
				else {
					System.out.println("roung");
				}
			}
			if(x==0){
				if(count==(x+1))
				{
				System.out.println("count:"+count);
					Matrix[x]=y;
				System.out.println("The Matrix at index:"+x+" and value:"+Matrix[x]);
					result=8;
				}
			}
			else {
				if(count==7)
				{
					
					System.out.println("count:"+count);
					Matrix[x]=y;
					System.out.println("The Matrix at index:"+x+" and value:"+Matrix[x]);
					out();
					result=8;
				}
				else if(count==(x))
				{
					System.out.println("count:"+count);
					Matrix[x]=y;
				System.out.println("The Matrix at index:"+x+" and value:"+Matrix[x]);
					result=8;
				}
			}
		return result;
	}
	public static boolean isSafeToPalce(int x1, int y1, int x2, int y2) {
		boolean safe = false;
		if ((x1 == 0) && (x2 == 0)  && (y2 == 0)) {
			safe = true;
		} else if (y1 == y2) {
			safe = false;
		} else if (Math.abs((y2 - y1)) == Math.abs((x2 - x1))) {
			safe = false;
		} else if (x1 == x2) {
			safe = false;
		} else {
			safe = true;
		}
		return safe;
	}
	public static void out()
	{
		System.out.println("The places are");
		for(int i=0;i<8;i++)
		{
			System.out.print("("+i+","+Matrix[i]+")\n");
		}
	}
	public static void main(String[] args) {
		Equeen eq=new Equeen();
		eq.EqueenFinder();
	}

}

