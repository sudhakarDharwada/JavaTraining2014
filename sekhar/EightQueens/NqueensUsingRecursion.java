import java.util.Scanner;
public class NqueensUsingRecursion {
	public static void main(String args[]){
		NqueensUsingRecursion t=new NqueensUsingRecursion();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the no. of queens:");
		int N=sc.nextInt();
		int[] n=new int[N];
		t.queen(n,0);
	}
	private static boolean isSafe(int x1, int y1, int x2, int y2) {
		if((x1==x2)||(y1==y2)||Math.abs(y2-y1)==Math.abs(x2-x1))
			return false;
		else 
			return true;
	}
	public void queen(int[] n,int index) {
		int count=0;
		if(index==n.length)
		{
			for(int i=0;i<n.length;i++){
				System.out.print("["+i+"-"+n[i]+"]");
				if(i<n.length-1)
					System.out.print(",");
			}
			System.out.println();
		}
		else
		{
			for(int value=0;value<n.length;value++)
			{
				count=0;
				for(int q=0;q<index;q++)
				{
					if(isSafe(q,n[q],index, value))
						count++;
				}
				if(count==index)
				{
					n[index]=value;
					queen(n,index+1);
				}
			}
		}
	}
}
