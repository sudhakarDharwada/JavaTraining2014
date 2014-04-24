
public class Test3 {
	public static void main(String[] args) {
		Thread1 t1=new Thread1();
		Thread3 t3=new Thread3();
		t1.start();
		t3.start();
		for(int i=101;i<=150;i++)
			System.out.println("main:"+i);
		System.out.println("end of main");
		

	}

}
