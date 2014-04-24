
public class Test2 {
	public static void main(String args[]){
		Thread2 t1=new Thread2("t1");
		t1.start();
		Thread2 t2=new Thread2("t2");
		t2.start();
		for(int i=51;i<=100;i++)
			System.out.println("i=:"+i);
		System.out.println("end of main");
	}

}
