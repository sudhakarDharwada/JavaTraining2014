package com.intendation;



import java.io.FileInputStream;
import java.io.IOException;

public class MainCode {

	public void logic(int content,  FileInputStream fis,int spacecount){
		
		try {
			while ((content = fis.read()) != -1) {


			if((char)content=='{'){

				spacecount+=4;
				System.out.print("\n");
				for(int i=0;i<spacecount;i++)
					System.out.print(" ");
				System.out.print((char)content);
			}
			else if((char)content=='}'){

				//System.out.println("first close..");
				System.out.print("\n");
				//System.out.println("closed....");
				for(int i=0;i<spacecount;i++)
					System.out.print(" ");
				spacecount-=4;
				System.out.print((char)content);
			}
			else if((char)content=='\n'){
				System.out.print("\n");
				for(int i=0;i<spacecount;i++)
					System.out.print(" ");

			}
			
			else{
				if((char)content==';'){
					
					System.out.print((char)content);
					System.out.print("\n");
					for(int i=0;i<spacecount;i++)
						System.out.print(" ");
					
					//System.out.print((char)content);
				}
				else{
					System.out.print((char)content);
				}
			}


}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
