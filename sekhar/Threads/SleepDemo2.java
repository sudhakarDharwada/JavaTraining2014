
public class SleepDemo2 {

	public static void main(String[] args) {
		boolean flag=true;
		long x=0;
		/*while(flag){
			x=x+1;
			System.out.println("x:"+x);
		}*/
		while(flag){
			x=x+1;
			System.out.println("x:"+x);
			try{
				Thread.sleep(600);
			}catch(Exception e){
			System.out.println(e);
			}
		}
	}

}
