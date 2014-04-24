package vl.com.threads;

class Feb
{
	public void print(int i)
	{
		int f1=0,f2=1;
		int f=0;
		for(int j=1;j<i;j++)
		{
			f=f1+f2;
			f1=f2;
			f2=f;
			System.out.print(f+" ");
		}
		System.out.println();
	}
}
class Main implements Runnable 
{
	int i;
	public Main(int i)
	{
		this.i=i;
	}
	Feb f8=new Feb();
	public void run() 
	{
		synchronized (f8) 
		{
			f8.print(i);
		}
	}
}
public class Test 
{
	public static void main(String[] args) throws InterruptedException 
	{
		for(int j=10;j>5;j--)
		{
			Thread t1=new Thread(new Main(j));
			t1.start();
			//Thread.sleep(50);
		}
	}
}
