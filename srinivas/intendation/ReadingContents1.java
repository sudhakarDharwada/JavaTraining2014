package com.intendation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadingContents1 {
	public static void main(String[] args) {

		
		FileInputStream fis =null;
		String filename;
		int spacecount=0;
		File file;

		try {

			ReadingFile rf = new ReadingFile();
			filename = rf.readfile();
			//file = new File(filename);
			
			file = new File(args[0]);
			fis = new FileInputStream(file);
			int content = 0;
			
			/*MainCode mc = new MainCode();
			mc.logic(content,fis,spacecount);*/
			

		}catch(FileNotFoundException f){
			System.out.println("file not found..");
		}
		catch (IOException e) {
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
