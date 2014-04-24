
public class SyThread3 extends Thread {
	Common c1;
	SyThread3(Common c1){
		this.c1=c1;
	}
	public void run(){
		c1.fun("C++");
	}

}
