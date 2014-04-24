
public class Thread2 extends Thread {
	private String threadName;
	private Thread t;
	Thread2(String name){
		this.threadName=name;
		System.out.println("creating thread:"+threadName);
	}
	public void run(){
		System.out.println("running thread:"+threadName);
		for(int i=0;i<=50;i++){
			System.out.println("thread:"+threadName+"="+i);
		}
		System.out.println("end of theread:"+threadName);
	}
//	public void start(){
//		System.out.println("starting theread:"+threadName);
//		if(t==null)
//		{
//			t=new Thread(this,threadName);
//			t.start();
//		}
//	}

}
