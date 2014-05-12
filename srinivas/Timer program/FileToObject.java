package com.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class FileToObject  {

	public BufferedReader br;
	public static List<EmpRemainder> list = new ArrayList<EmpRemainder>();
	TimerClass tc = new TimerClass();
	Date date ;


	public List<EmpRemainder> filetoobj(File file) throws NumberFormatException, IOException, ParseException {

		br = new BufferedReader(new FileReader(file));
		String line;

		while ((line = br.readLine()) != null) {

			EmpRemainder emp = new EmpRemainder();

			StringTokenizer st = new StringTokenizer(line);

			while (st.hasMoreTokens()) {

				//Name
				String name =st.nextToken();
				emp.setName(name);
				//System.out.print(name);

				//Date
				String dateInString =st.nextToken();

				//Time
				String timeInString =st.nextToken();

				Timestamp ts = Timestamp.valueOf(dateInString+" "+timeInString);
				emp.setTimestamp(ts);
				//System.out.println(ts);

				list.add(emp);

			}
		}

		return list;
	}


	public void remainder(){

		Iterator<EmpRemainder> i = list.listIterator();
		Iterator<EmpRemainder> ii = list.listIterator();

		while(ii.hasNext()){

			EmpRemainder err =ii.next();
			System.out.println(err.name+"----->"+err.timestamp);
		}

		while(true){
			
			while(i.hasNext()){

				EmpRemainder er =i.next();
				long time=er.timestamp.getTime()-System.currentTimeMillis();

				if(time<0){
				}

				else{
					synchronized (tc) {

						try {
							tc.wait(time);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("hai to... "+er.name);
					}
				}
			}
		}

	}
}
