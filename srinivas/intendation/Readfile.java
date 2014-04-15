package com.intendation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Readfile {
	public static void main(String[] args) 
	{
		System.out.println("Reading from file : " );
	    try
	    {
	    	String path = "/home/valuelabs/workspace/Bs/src/com/intendation/Test.java";
	    	InputStream inputFile = new FileInputStream(path);
	    	int size =inputFile.available();
	    	System.out.println(size);
	    	char data=' ';
	    	int countdepth=0;
	    	for(int i=0; i<size; i++)
	    	{
	    		data=(char)inputFile.read();
	    		if(data=='{')
	    		{
	    			System.out.print('\n');
	    			for(int j=0;j<countdepth;j++)
	    				System.out.print("  ");
	    			countdepth+=3;
	    			System.out.print(data);
	    		}
	    		else if(data=='\n')
	    		{
	    			System.out.print('\n');
	    			for(int j=0;j<countdepth;j++)
	    				System.out.print("  ");
	    			//System.out.print(data);
	    		}
	    		else if(data=='}')
	    		{
	    			countdepth=countdepth-3;
	    			System.out.print('\n');
	    			for(int j=0;j<countdepth;j++)
	    				System.out.print("  ");
	    			System.out.print(data);
	    		}
	    		else
	    		System.out.print(data);
	    	}
	    	inputFile.close();
	    }
	    catch(IOException e)
	    {
	        System.out.print("Exception");
	    }
	}
}




