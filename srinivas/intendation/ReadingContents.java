package com.intendation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadingContents{

	public static void main(String[] args) {

		File file = new File("/home/valuelabs/workspace/Bs/src/com/intendation/Test.java");
		FileInputStream fis = null;
		int bracecount=0;
		int spacecount=4;

		try {
			fis = new FileInputStream(file);

			System.out.println("Total file size to read (in bytes) : "+ fis.available());

			int content;
			while ((content = fis.read()) != -1) {

				if((char)content==';'){
					//fis.skip(1);
					
					
					//System.out.println(";");
					System.out.println("\n");
				}

				if((char)content=='{')
				{
					bracecount++;

					spacecount += 4;

					System.out.print((char) content);

					System.out.println("\n");
				}

				if((char)content=='}'){

					bracecount--;
					spacecount-=4;
					System.out.print((char) content);
					System.out.println("\n");
				}
				// convert to char and display it
				
				
				if((char)content!='{' || (char)content!='}')
					System.out.print((char) content);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}