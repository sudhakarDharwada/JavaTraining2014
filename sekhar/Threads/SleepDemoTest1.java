
public class SleepDemoTest1 {

	public static void main(String[] args) {
		SleepDemo1 sd1=new SleepDemo1();
		sd1.start();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		for(int i=51;i<=100;i++)
			System.out.println("main:"+i);
		System.out.println("end of main");

	}

}
