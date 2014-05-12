package vl.com.threads;

import java.io.IOException;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		String file="/home/valuelabs/bdaybtls.properties";
		Timer t=new Timer();
		t.readdtls(file);
		t.generatealert();
	}
}
