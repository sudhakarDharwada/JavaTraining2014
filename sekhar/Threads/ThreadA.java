
public class ThreadA implements Runnable {
	public void run() {
		System.out.println("begining of ThreadA");
		for(int i=0;i<=50;i++)
			System.out.println("ta:"+i);
		System.out.println("end of ThreadA");
	}
	

}
