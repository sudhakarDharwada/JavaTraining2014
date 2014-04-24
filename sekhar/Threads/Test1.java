
public class Test1{

	public static void main(String[] args) {
		Thread1 t=new Thread1();
		t.start();
		for(int i=50;i<100;i++){
			System.out.println("i="+i);
		}
		System.out.println("i am in main");		
	}

}
