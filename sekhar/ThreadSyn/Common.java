
public class Common {
	synchronized public void fun(String s1)
	//public void fun(String s1)
	{
		System.out.print("{Hello["+s1);
		try{
			Thread.sleep(200);
		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println("]world}");
	}

}
