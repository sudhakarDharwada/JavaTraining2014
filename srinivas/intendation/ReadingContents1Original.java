package com.intendation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadingContents1Original {
	public static void main(String[] args) {

		File file = new File("/home/valuelabs/workspace/Bs/src/com/intendation/Test.java");
		FileInputStream fis = null;
		
		int spacecount=0;

		try {
			fis = new FileInputStream(file);


			int content;
			while ((content = fis.read()) != -1) {


				if((char)content=='{'){

					System.out.print('\n');
					for(int j=0;j<spacecount;j++)
						System.out.print("  ");
					spacecount+=3;
					System.out.print((char)content);
				}
				
				else if((char)content=='}'){
					spacecount-=3;
					System.out.print('\n');
					for(int j=0;j<spacecount;j++)
						System.out.print("  ");
					System.out.print((char)content);
				}
				
				else if((char)content=='\n'){
					
	    			System.out.print('\n');
	    			for(int j=0;j<spacecount;j++)
	    				System.out.print("  ");
	    			
	    		}

				else{				
					System.out.print((char)content);
				}

			}
		}catch (IOException e) {
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
