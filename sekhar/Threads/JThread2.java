
public class JThread2 extends Thread{
	public void run(){
		System.out.println("begning of JThread2");
		for (int i=51;i<=100;i++)
			System.out.println("jt2:"+i);
		System.out.println("end of JThread2");
	}

}
