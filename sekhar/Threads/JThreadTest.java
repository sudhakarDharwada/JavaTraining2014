
public class JThreadTest {
	public static void main(String args[]){
		JThread1 t1=new JThread1();
		JThread2 t2=new JThread2();
		JThread3 t3=new JThread3(t1);
		t1.start();
		t2.start();
		t3.start();
	}
}
