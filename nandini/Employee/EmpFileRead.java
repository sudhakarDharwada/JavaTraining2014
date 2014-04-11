import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
//import java.util.StringTokenizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
public class EmpFileRead{
	public static void main(String args[]){
		File file = null;
		if (0 < args.length) {
			file = new File(args[0]);
			List<EmpList> empList=new ArrayList<EmpList>();
			ReadFileData rd = new ReadFileData();
			rd.readData(file,empList);
			rd.empWorkinghrs(empList);
			rd.empDetails(empList);
		}
		
		if (!file.exists()) {
			System.out.println(file + " does not exist.");
			return;
		}
		if (!(file.isFile() && file.canRead())) {
			System.out.println(file.getName() + " cannot be read from.");
			return;
		}
	}
}
class ReadFileData{
		void readData(File file,List empList){
		int id;
		boolean inout;	
		FileReader fr=null;
		BufferedReader br=null;		
		String emp[]=new String[3];		
		try{
			fr=new FileReader(file);
			br=new BufferedReader(fr);
			String line=null;
			EmpList el;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	
			while((line=br.readLine())!=null){
				StringTokenizer st = new StringTokenizer(line, ";");
				int i=0;
				while (st.hasMoreElements()) {
					String d=(String)st.nextElement();
					emp[i]=d;						
					i++;
				}
				id=Integer.parseInt(emp[0]);
				inout=Boolean.parseBoolean(emp[1]);
				Date d= sdf.parse(emp[2]);
				el=new EmpList(id,inout,d);
				empList.add(el);
			}
			Iterator<EmpList> in = empList.iterator();
			while(in.hasNext()) 
			{
				EmpList emp1= in.next();
				System.out.println(emp1);
			}
			
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}
	void empWorkinghrs(List empList)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the empid who working hours to be calculated");
		int empid=sc.nextInt();
		int hours=0,mins=0,sec=0;
		//System.out.println("Im in in");
		Iterator<EmpList> it1=empList.iterator();
		while(it1.hasNext())
		{
			
			EmpList emp1=new EmpList();
			emp1=(EmpList)it1.next();
			if((emp1.getEmpId()==empid) && (emp1.getEmpInout()==true))
			{
				System.out.println("Im in in");
				Iterator<EmpList>  it2=empList.iterator();
				while(it2.hasNext())
				{
					EmpList emp2=new EmpList();
					emp2=(EmpList)it2.next();
					if(((emp2.getEmpInout()==false))&&((emp2.getEmpDate().getDate())==emp1.getEmpDate().getDate())&&((emp2.getEmpId())==empid))
					{
							System.out.println("Im in in");
							hours+=emp2.getEmpDate().getHours()-emp1.getEmpDate().getHours();
							mins+=Math.abs(emp2.getEmpDate().getMinutes()-emp1.getEmpDate().getMinutes());
							break;
					}
				}
			}
		}
		System.out.println("Working hours : "+hours+" hours "+mins+" Minutes" +sec+" Seconds");
	}
	void empDetails(List empList){
		Date d=new Date();
		try
		{
			Scanner sc=new Scanner(System.in);
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("Enter the date to know no of persons yyyy-mm-dd");
			String date=sc.next();
			d = sdf1.parse(date);
			System.out.println(d);
			Set<EmpList> uniqset = new HashSet<EmpList>(empList);
			System.out.println("Persons present on the given date are");		
			Iterator<EmpList> itr1=empList.iterator();		
			while(itr1.hasNext())
			{
				EmpList empl=new EmpList();
				empl=(EmpList)itr1.next();	
				uniqset.add(empl);			
				//int i=uniqset.add(empl);
				if((empl.getEmpDate().getYear()==d.getYear())&&(empl.getEmpDate().getMonth()==d.getMonth())&&(empl.getEmpDate().getDate()==d.getDate()))
				{
					int i=empl.getEmpId();
					System.out.println(i);
				}	
			}
		}
		catch(ParseException p){
			p.printStackTrace();	
		}
	}
}
