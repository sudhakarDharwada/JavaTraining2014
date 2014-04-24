public class Thread3 extends Thread{
	public void run(){
		System.out.println("begning of thread3");
		for(int i=51;i<=100;i++)
			System.out.println("t3:"+i);
		System.out.println("end of thread3");
	}

}
