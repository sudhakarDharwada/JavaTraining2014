package com.syncaccdetails;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

public class FileToObject extends Thread {

	public  BufferedReader br;

	
	static Map<Integer,ChangedAmount> m = new HashMap<Integer,ChangedAmount>();

	public   Map<Integer, ChangedAmount>  filetoobj(EmpAcc emp, String operation,int amount) throws NumberFormatException, IOException, InterruptedException {


		ChangedAmount ca =m.get(emp.AccId);

		if(ca == null){

			synchronized (m) {

				ChangedAmount caa =m.get(emp.AccId);

				if(caa == null){
					m.put(emp.AccId,new ChangedAmount(amount));
				}

				else if(operation.equals("dep")){

					caa.deposit(amount);

				}
				else if(operation.equals("wit")){

					caa.deduct(amount);
				}


			}
		}
		else{
			synchronized (ca) {

				if(operation.equals("dep")){
					ca.deposit(amount);
				}

				else if(operation.equals("wit")){
					ca.deduct(amount);
				}
			}
		}
		return m;
	}
}
