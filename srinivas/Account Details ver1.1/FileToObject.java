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

	public Map<Integer, ChangedAmount> filetoobj(File file) throws NumberFormatException, IOException {

		Map<Integer,ChangedAmount> m = new HashMap<Integer,ChangedAmount>();


		br = new BufferedReader(new FileReader(file));
		String line;

		while ((line = br.readLine()) != null) {

			EmpAcc emp = new EmpAcc();

			StringTokenizer st = new StringTokenizer(line);

			while (st.hasMoreTokens()) {

				//Id
				String id =st.nextToken();
				int accid = Integer.parseInt(id);
				emp.setAccId(Integer.parseInt(id));

				//Deposit/Withdraw
				String operation =st.nextToken();
				emp.setOperation(operation);

				//Amount
				int amount =Integer.parseInt(st.nextToken());
				emp.setAmount(amount);


				ChangedAmount cc =m.get(accid);

				if(cc==null){


					ChangedAmount ca  = new ChangedAmount(amount);

					m.put(accid,ca);

				}
				else{


					if(operation.equals("dep")){

						cc.deposit(amount);
						//System.out.println(ca.amount);


					}

					else if(operation.equals("wit")){

						cc.deduct(amount);
						//System.out.println(ca.amount);

					}	


				}


			}

		}

		return m;
	}
}