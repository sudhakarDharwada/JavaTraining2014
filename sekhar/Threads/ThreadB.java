
public class ThreadB implements Runnable {
	public void run(){
		System.out.println("bigining of ThreadB");
		for(int i=51;i<=100;i++)
			System.out.println("tb:"+i);
		System.out.println("end of ThreadB");
	}

}
