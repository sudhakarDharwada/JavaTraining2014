
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class InputFile   
{  
	public static void main(String args[])  
	{  
		try { 
			BufferedReader in = new BufferedReader(new FileReader("input.txt"));
			List<EmpDetails> list = new ArrayList<EmpDetails>();
			EmpDetails eRecord = null;
			String str;
			StringTokenizer sTokenizer=null;
			while ((str = in.readLine()) != null) {
				sTokenizer=new StringTokenizer(str, " ");
				String st[]=new String[3];
				int i=0;
				while(sTokenizer.hasMoreTokens())
				{
					st[i]=sTokenizer.nextToken();
					i++;
				}
				if (st[0]!=null) {
					int id = Integer.parseInt(st[0]);
					String status = st[1];
					int hours = Integer.parseInt(st[2]);
					//Date date = new Date();
					//date.setHours(hours);
					eRecord = new EmpDetails(id, status, hours);
					list.add(eRecord);
				}

				System.out.println("id:"+eRecord.getEmpid()+" status:"+eRecord.getStatus()+" time:"+eRecord.getTime());

			}
			in.close();
		}
		catch (Exception e){ 
			System.err.println("Error: " + e.getMessage());  
		}  
	}  
}  