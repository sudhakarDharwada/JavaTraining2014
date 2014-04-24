
public class SyThread1 extends Thread {
	Common c1;
	SyThread1(Common c1){
		this.c1=c1;
	}
	public void run(){
		c1.fun("java");
	}

}
