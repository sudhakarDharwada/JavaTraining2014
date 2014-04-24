
public class Thread1 extends Thread{
	public void run(){
		for(int i=0;i<50;i++){
			System.out.println("i="+i);
		}
		System.out.println(" i am in thread1");
	}

}
