
public class SleepDemo1 extends Thread {
	public void run(){
		System.out.println("begining of SleepDemo1");
		
		for(int i=0;i<=50;i++)
			System.out.println("sd1:"+i);
		System.out.println("end of SleepDemo1");
	}
}
