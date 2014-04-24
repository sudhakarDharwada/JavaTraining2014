
public class JThread1 extends Thread {
	int sum;
	public void run(){
		System.out.println("begning of JThread1");
		for(int i=1;i<=50;i++){
			System.out.println("jt1:"+i);
			sum=sum+i;
		}
		System.out.println("end of JThread1");
	}

}
