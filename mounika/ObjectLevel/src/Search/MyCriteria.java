package Search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Criteria {
	abstract public boolean compare(Object[] addEmp,Object sEmp);

}
public class MyCriteria extends Criteria{
	
	 public static void main(String args[])
     {
             MyCriteria c1 =new MyCriteria();

             Employee sEmp = new Employee();
             
             Employee[] addEmp=Employee.readEmps();
             
      boolean type,result;
       type = c1.compare(addEmp,sEmp);
       result=  biSearchEmp(addEmp,type,sEmp );
      if(result)
              System.out.println("Element found");
      else
              System.out.println("Element not found");

     }
	
	 public void sortEmp(Employee[] addEmp){

	        Employee temp = new Employee();



	        for (int i = 0 ; i <= ( addEmp.length - 1 ); i++)
	          {
	            for (int j = 0 ; j <= addEmp.length - i - 1; j++)
	            {
	              if (addEmp[j].empId > addEmp[j+1].empId) /* For decreasing order use < */
	              {
	                temp.empId       = addEmp[j].empId;
	                addEmp[j].empId   = addEmp[j+1].empId;
	                addEmp[j+1].empId = temp.empId;
	              }
	            }
	          }

	}

private static boolean biSearchEmp(Employee[] addEmp, boolean type, Employee sEmp1) {
		 int low = 0;
         int high = addEmp.length;
         //System.out.println(addEmp.length);
         int mid=(low+high)/2;
         Scanner in=new Scanner(System.in);

        Employee sEmp=(Employee)sEmp1;
        if(type)
         {
       //  Scanner in=new Scanner(System.in);
         sEmp.empId=in.nextInt();
         do
         {
             mid = (low + high) / 2;
             if (sEmp.empId < addEmp[mid].empId)
                 high = mid - 1;
             else if (sEmp.empId > addEmp[mid].empId)
                 low = mid + 1;
         } while (sEmp.empId != addEmp[mid].empId && low <= high);
         if (sEmp.empId == addEmp[mid].empId)
         {
            
          return true;
         }
         else
         {
            
         return false;
         }

         }

         else
         {
         System.out.println("Enter name to Search");
         sEmp.empName=in.next();
        int c;

         for (c = 0; c<addEmp.length ; c++)
         {
           if (addEmp[c].empName.equals(sEmp.empName))     /* Searchingelement is present */
           {
                 
                   return true;
           }
        }
        if (c == addEmp.length)  /* Searching element is absent */
        {
         
           return false;
        }
         return false;}
	}

 
	public boolean compare(Object[] addEmp, Object sEmp) {
        int type;
Scanner in=new Scanner(System.in);

        while(true)
        {
        System.out.println("Enter 0 to serach by id and 1 to search by name");
        type =in.nextInt();
        

    if(type==0)
    {
            System.out.println("Enter id to Search");
   
            return true;
    }
            if(type==1)
    return false;
}
}
}