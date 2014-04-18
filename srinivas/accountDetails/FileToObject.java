package com.accountDetails;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FileToObject {

	public BufferedReader br;
	int final_amount=0;

	public Map<Integer, Integer> filetoobj(File file) throws NumberFormatException, IOException {

		Map<Integer,Integer> m = new HashMap<Integer,Integer>();

		br = new BufferedReader(new FileReader(file));
		String line;

		while ((line = br.readLine()) != null) {

			EmpAcc emp = new EmpAcc();

			StringTokenizer st = new StringTokenizer(line);

			while (st.hasMoreTokens()) {

				String id =st.nextToken();
				int accid = Integer.parseInt(id);
				emp.setAccId(Integer.parseInt(id));

				String operation =st.nextToken();
				emp.setOperation(operation);

				String amount =st.nextToken();
				emp.setAmount(Integer.parseInt(amount));


				if(operation.equals("dep")){

					if(m.containsKey(emp.getAccId())){

						final_amount = m.get(accid);
						final_amount += emp.getAmount();
						m.put(emp.getAccId(), final_amount);


					}
					else{

						final_amount = emp.getAmount();
						m.put(emp.getAccId(), final_amount);
						
					}
				}
				else if(operation.equals("wit")){
					if(m.containsKey(emp.getAccId())){

						final_amount = m.get(accid);

						final_amount -= emp.getAmount();


						m.put(emp.getAccId(), final_amount);
					}else{
						
						final_amount -= emp.getAmount();

						m.put(emp.getAccId(), final_amount);

					}
				}

			}
		}
		return m;
	}
}
