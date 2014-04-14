import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
class ReadingEmployeeDetails
{
	public void readingFile(File inFile,List empList){
		BufferedReader br = null;
		int id=0;
		boolean flag=true;
		Date date;
		String line;
		String e[]=new String[3];
		
		try {
			
			br = new BufferedReader(new FileReader(inFile));
			while((line = br.readLine()) != null){
				StringTokenizer st = new StringTokenizer(line,";");
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				int i=0;
				while (st.hasMoreElements()) {
					String d=(String)st.nextElement();
					e[i]=d;
					i++;
				}
				id=Integer.parseInt(e[0]);
				flag=Boolean.parseBoolean(e[1]);
				date=df.parse(e[2]);
				EmployeeDetails ed=new EmployeeDetails(id,flag,date);
				empList.add(ed);	
			}
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		} 
		catch (ParseException e1){
			System.out.print(e1);
		}
		catch (NullPointerException e1){
			System.out.print(e1);
		} 
		finally {
			try {
				if (br != null)br.close();
			} 
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	public void noOfEmployees(List empList){
		String el[]=new String[2];
		Date date1;
		Scanner sc=new Scanner(System.in);
		Date d2=new Date();
		try{
			System.out.println("enter date in yyyy-mm-dd format");
			String abc=sc.next();
			SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
			d2=df2.parse(abc);
			EmployeeDetails emp;
			Iterator<EmployeeDetails> it = empList.iterator();
			Set<Integer> uniqueSet = new HashSet<Integer>();
			while(it.hasNext())
			{
				emp=it.next();
				if (emp.getDate1().getDate() == d2.getDate() && emp.getDate1().getMonth() == d2.getMonth() &&  emp.getDate1().getYear() == d2.getYear())  
				{
					uniqueSet.add(emp.getEmpId());
				}	
			}
			System.out.println("No of employees present are "+uniqueSet.size());	
		}
		catch(Exception e2)
		{
			System.out.print(e2);
		}	
	}
	public void employeeLoginDetails(List empList){
		
		Scanner s=new Scanner(System.in);
		System.out.println("enter the employee Id");
		int id=s.nextInt();
		Iterator<EmployeeDetails> i = empList.iterator();
		while (i.hasNext()) {
			EmployeeDetails info = i.next();
			if (info.getEmpId()==id)
				System.out.println(info);
		} 
		
	}
	public void employeeWorkingHours(List empList){
		Scanner s1=new Scanner(System.in);
		System.out.println("enter the employee id to print working hours");
		int eId=s1.nextInt();
		int hour=0, min=0;
		Iterator<EmployeeDetails> i1 = empList.iterator();
		Iterator<EmployeeDetails> i2;
		while(i1.hasNext())
		{
			EmployeeDetails ed1=new EmployeeDetails();
			EmployeeDetails ed2=new EmployeeDetails();
			ed1=i1.next();
			if((ed1.getEmpId()==eId) && (ed1.getFlag()==true))
			{
				i2=empList.iterator();
				while(i2.hasNext()){
					ed2=i2.next();
					if(((ed2.getFlag()==false))&&((ed2.getDate1().getDate())==ed1.getDate1().getDate())&&((ed2.getEmpId())==eId))
					{
							hour+=ed2.getDate1().getHours()-ed1.getDate1().getHours();
							min+=Math.abs(ed2.getDate1().getMinutes()-ed1.getDate1().getMinutes());
							break;
					}
					  
				}
			}
			
		}
	System.out.println("Working hours : "+hour+" hours "+min+" Minutes");
	}
}
