
public class SyThread2 extends Thread {
	Common c1;
	SyThread2(Common c1){
		this.c1=c1;
	}
	public void run(){
		c1.fun("oracle");
	}

}
