import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.text.SimpleDateFormat;  
import java.util.ArrayList;
import java.util.Iterator;

public class ReadEmpFile{
      public static void main(String [] args) throws IOException{
	   
           List<EmployeeDetails> empList=new ArrayList<EmployeeDetails>(); 
	   EmployeeSearch es = new EmployeeSearch();
           es.readFile();
           Scanner choice=new Scanner(System.in);
           System.out.println("Enter your choice \n1 :Find no.of employees on particular day \n 2:Working hours of an employee");

	   int option=choice.nextInt();
           if(option == 1){
                es.searchByDate(empList);
           }
           else if(option == 2){
                es.employeeWorkingHours(empList);
           }

           else{
               System.out.println("Invalid Entry");
           }

      }
}


class EmployeeSearch{

   void readFile(){
       
           Scanner inFile = new Scanner(new File("Details.txt"));
	   while (inFile.hasNext()){
	       String line = inFile.nextLine();
               StringTokenizer st = new StringTokenizer(line, ";");
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
               String arr[] = new String[st.countTokens()];          
	       int i=0;
               while(st.hasMoreTokens()){
                   arr[i] = st.nextToken();
                   i++;
               }

	       int id=Integer.parseInt(arr[0]);
               Boolean flag=Boolean.parseBoolean(arr[1]);
               Date date=sdf.parse(arr[2]);
               EmployeeDetails ed=new EmployeeDetails(id,flag,date);
               empList.add(ed);	
           }
}
   public void searchByDate(List empList) {
Date d = new Date();
        try{
           Scanner s = new Scanner(System.in);
           SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");           
           System.out.print("Enter the Date to search in yyyy-MM-dd format:");
           String date1 = s.next();
           d=sdf1.parse(date1);
           Iterator<EmployeeDetails> itr = empList.iterator();
           Set<Integer> set=new HashSet<Integer>();
           while (itr.hasNext()) {
              EmployeeDetails empDetail = (EmployeeDetails) itr.next();
              if ((empDetail.compareTo(d))) {
                  set.add(empDetail.getEmpId());
              }
           }
           System.out.println("\n Employees present in this Date\n"+set);
       }

       catch(Exception e){
            System.out.print(e);
       }	

    }


  public void employeeWorkingHours(List empList){
          Scanner s1=new Scanner(System.in);
          System.out.println("Enter employee id ");
          
          int empid=s1.nextInt();
          int hour=0, min=0;
          Iterator<EmployeeDetails> itr1 = empList.iterator();
          Iterator<EmployeeDetails> itr2 = empList.iterator();

          while(itr1.hasNext()){

		EmployeeDetails ed1=new EmployeeDetails();
                EmployeeDetails ed2=new EmployeeDetails();
                ed1=itr1.next();

                if((ed1.getEmpId()==empid) && (ed1.getFlag()==true)){
                       itr2=empList.iterator();

                       while(itr2.hasNext()){
                            ed2=itr2.next();

	                    if(((ed2.getFlag()==false))&&((ed2.getEDate().getDate())==ed1.getEDate().getDate())&&((ed2.getEmpId())==empid)){

                                  hour+=ed2.getEDate().getHours()-ed1.getEDate().getHours();
                                  min+=Math.abs(ed2.getEDate().getMinutes()-ed1.getEDate().getMinutes());
                                  break;
                            }

			}

		}
			
	}

	System.out.println("Working hours : "+hour+" hours "+min+" Minutes");

  }

}



















