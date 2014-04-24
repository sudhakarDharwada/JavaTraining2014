
public class JThread3 extends Thread{
	JThread1 t1;
	JThread3(JThread1 t1){
	this.t1=t1;
	}
	public void run(){
		System.out.println("begning of JThread3");
		for(int i=101;i<=150;i++){
			System.out.println("jt3:"+i);
			if(i==122)
			{
				try{
					t1.join();
				}catch(Exception e){
					System.out.println(e);
				}
			System.out.println("sum of 50 no's:"+t1.sum);
			}
		}
		System.out.println("end of JThread3");
	}
}
