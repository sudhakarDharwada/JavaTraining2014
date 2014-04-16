package Search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee {
	
        int empId;
        String empName;
       public int getEmpId() {
                return empId;
        }
        public void setEmpId(int empId) {
                this.empId = empId;
        }
        public String getEmpName() {
                return empName;
        }
        public void setEmpName(String empName) {
                this.empName = empName;
        }
        public static  Employee[] readEmps(){
        	
          int count=0;
         // System.out.println("type negative number for id to end giving Employee details");
          List empList=new ArrayList();
          Scanner sc=new Scanner(System.in);
          System.out.println("enter arraySize");
          int n= sc.nextInt();
          Employee[] addEmp=new Employee[n];


            while(true)
        {

               
                Scanner  in=new Scanner(System.in);
                  //  int a=in.nextInt();
                    if (count>=n)
                        break;
                    System.out.println("Enter id");
                        int a=in.nextInt();

                if(a<0)
                        break;
                System.out.println("Enter name");

                String name=in.next();

                addEmp[count]=new Employee();
                addEmp[count].setEmpId(a);
                addEmp[count].setEmpName(name);
      //    empList.add(addEmp[i]);
                        count++;


        }

   return addEmp; }

}


