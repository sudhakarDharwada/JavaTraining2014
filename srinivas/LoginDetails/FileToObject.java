package com.temp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FileToObject {

	public Map filetoobj(File file) throws NumberFormatException, IOException, ParseException{

		Emp[] emp = new Emp[100];
		
		int i=0;

		Map<Emp,Integer> m = new HashMap<Emp,Integer>();

		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

		while ((line = br.readLine()) != null) {



			StringTokenizer st = new StringTokenizer(line);

			while (st.hasMoreTokens()) {
				emp[i] = new Emp();

				String id =st.nextToken();

				emp[i].setId(Integer.parseInt(id));

				//System.out.println("Id " +emp[i].getId());

				String time =st.nextToken();

				DateFormat inFormat = new SimpleDateFormat( "hh:mm:ss");
				
				
				
				Date date1 = null;
				

				date1 = inFormat.parse(time);


				//System.out.println("Time is "+date1);

				emp[i].setTime(date1);
				
				String datetemp =st.nextToken();
				Date date = formatter.parse(datetemp);

				emp[i].setDate(date);


				//System.out.println(emp[i].getDate());

				m.put(emp[i], i+1);


			}
			i++;
		}

		
		return m;

	}
}
