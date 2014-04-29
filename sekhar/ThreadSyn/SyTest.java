
public class SyTest {
	public static void main(String args[]){
		Common c1=new Common();
		SyThread1 t1=new SyThread1(c1);
		SyThread2 t2=new SyThread2(c1);
		SyThread3 t3=new SyThread3(c1);
		t1.start();
		t2.start();
		t3.start();
		
	}

}
