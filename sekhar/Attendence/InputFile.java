import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class InputFile
{
	public static void main(String[] args)
	{
		try
		{
			InputFile if1=new InputFile();
			String fname=args[0];
			List<EmpDetails> list=if1.readinput(fname);
			Scanner sc1=new Scanner(System.in);
			String ch="y";
			while(ch.equalsIgnoreCase("y"))
			{
				System.out.println("enter your choice \n1.workinghours of the employee\n2.no. of employees on that day");
				int choice=sc1.nextInt();
				if(choice==1)
				{
					System.out.println("enter empid:");
					int id=sc1.nextInt();
					if1.workingtime(list,id);
				}
				else if(choice==2)
					if1.employeepresent(list);
				else
					System.out.println("not a valid choice.");
				System.out.println("do you want to continue[y/n] :");
				ch=sc1.next();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	public List<EmpDetails> readinput(String file) throws FileNotFoundException
	{	
		FileReader re = new FileReader(file);
		Scanner sc =new Scanner(new BufferedReader(re));
		List<EmpDetails> list=new ArrayList<EmpDetails>();
		while(sc.hasNext())
		{
			int empid=Integer.parseInt(sc.useDelimiter("  ").next().trim());
			boolean status=Boolean.parseBoolean(sc.useDelimiter("  ").next().trim());
			String dates=sc.useDelimiter("\n").next();
			EmpDetails emp=new EmpDetails(empid,status,dates);
			list.add(emp);
		}
		return list;
	}
	public void employeepresent(List<EmpDetails> list)
	{
		int no_of_emp=0;
		for(int j=0;j<list.size();j++){
			int thisempid=list.get(j).getempId();
			boolean seen_this_emp=false;
			for(int i=0;i<j;i++){
				if(thisempid==list.get(i).getempId()){
					seen_this_emp=true;
				}
			}
			if(!seen_this_emp){
				no_of_emp ++;
			}
		}
		if(no_of_emp==0)
			System.out.println("none of emplyoee present");
		else
			System.out.println("no of employees on  day "+no_of_emp);
	}
	public void workingtime(List<EmpDetails> list,int empid)
	{
		int i=0;
		int intime=0;
		int outtime=0;
		long totalhrs=0;
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		java.util.Date d1 = null;
		java.util.Date d2 = null;
		while(i<list.size())
		{
			if((empid==list.get(i).getempId()))
			{
				if(list.get(i).getStatus())
					intime=i;
				else
					outtime=i;
			}
			if(outtime!=0)
			{	try {
				d1 = format.parse(list.get(intime).getDate());
				d2 = format.parse(list.get(outtime).getDate());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			totalhrs = (d2.getTime() - d1.getTime())+totalhrs;
			outtime=0;
			}
			i++;
		}
		if(totalhrs==0)
			System.out.println("employee not present on that date");
		else{
			long Seconds = totalhrs / 1000 % 60;
			long Minutes = totalhrs / (60 * 1000) % 60;
			long Hours = totalhrs / (60 * 60 * 1000);
			System.out.println("the emplyoee work in "+Hours+":"+Minutes+":"+Seconds);
		}
	}

}
