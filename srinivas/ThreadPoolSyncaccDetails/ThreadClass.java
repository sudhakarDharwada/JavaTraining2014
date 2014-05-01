package com.ThreadPoolSyncaccDetails;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ThreadClass  extends Thread{

	FileToObject fto;
	File file;
	BufferedReader br;
	String name;

	ThreadClass(FileToObject fto,File file,String name){

		this.fto = fto;
		this.file = file;

		this.name = name;
	}

	public void run(){
	
		try {
			
			
			br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {

				StringTokenizer st = new StringTokenizer(line);
				while (st.hasMoreTokens()) {
					// Id
					String id =st.nextToken();
					int accid = Integer.parseInt(id);
					
					EmpAcc emp = new EmpAcc(accid);
					
					// Deposit/Withdraw
					String operation =st.nextToken();

					// Amount
					int amount =Integer.parseInt(st.nextToken());
					fto.filetoobj(emp,operation, amount);
				} 
			}
		}catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	
	}

}