package com.intendation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Indentation2 {

	public  void indentFile(String fileName) {
		
		File file=new File(fileName);
		FileInputStream fis = null;

		try {
			
			fis = new FileInputStream(file);
			
		} catch (FileNotFoundException e) {
			
			System.out.println("file is not available. Enter file name including path....");
			e.printStackTrace();
		}
		
		char data=' ';
		int countdepth=0;
		boolean isNewLine=false;
		int a=0; 
		int size = 0;
		
		try {
			size = fis.available();
		} catch (IOException e) {

			
			e.printStackTrace();
		}
		while(size!=-1)
		{ 
			try {
				data=(char)fis.read();
			} catch (IOException e) {

				e.printStackTrace();
			}
			
			switch (data) 
			{
			
			case '{':
				a=countdepth;
			countdepth+=3;
			System.out.print('\n');
			
			for(int j=0;j<a;j++ )
			{
				System.out.print(" ");
			}
			
			System.out.println(data);
			break;
			
			case '}':
				countdepth-=3;a=countdepth;
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
					for(int i=0;i<countdepth;i++)
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
