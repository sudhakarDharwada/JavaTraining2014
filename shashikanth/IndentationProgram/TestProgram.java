package com.Io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TestProgram 
{
	public static void main(String[] args) throws IOException
	{
		String fileName=args[0];
		TestProgram.indentFile(fileName);
	
	}
	private static void indentFile(String fileName) throws IOException {
		File file=new File(fileName);
		FileInputStream fis=new FileInputStream(file);
		char data=' ';int depth=0;boolean isNewLine=false;int a=0;
        int size=fis.available();
        while(size!=-1)
        { 
        	data=(char)fis.read();
            switch (data) 
            {
			  case '{':
				a=depth;
				depth+=3;
				System.out.print('\n');
				for(int j=0;j<a;j++ )
				{
					System.out.print(" ");
				}
				System.out.println(data);
				break;
			  case '}':
			  depth-=3;a=depth;
			  System.out.print('\n');
			  for(int j=0;j<a;j++ )
			  {
					System.out.print(" ");
			  }
			  System.out.println(data);
			    break;
			  case ' ':
				 if(!isNewLine)
				 {	 
					 System.out.print(data);
				 }
                 break;
			  case '\t':
				  if(!isNewLine)
					 {					  
						 System.out.print(data);
					 }
	                 break;
			  case '\n':
				  isNewLine=true;
				  break;
			  case ';':
				  System.out.println(data);
			      break;
				 
			default:
				if(isNewLine)
				{ 
					for(int i=0;i<depth;i++)
					{
					  System.out.print(" ");
					}
				}
				
				isNewLine=false;
				System.out.print(data);
				break;
			}
        	size--;
        }
	}
}
