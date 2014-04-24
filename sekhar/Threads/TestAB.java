
public class TestAB {
	public static void main(String args[]){
		ThreadA ta=new ThreadA();
		ThreadB tb=new ThreadB();
		//ta.start();we are getting error becoz there is no start() in ThreadA class
		Thread t1=new Thread(ta);//has-a relation
		Thread t2=new Thread(tb);//has-a relation
		t1.start();
		t2.start();
		System.out.println("end of main");
	}
}
