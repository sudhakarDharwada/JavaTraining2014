import java.util.*;  
import java.util.Scanner;

public class DeptRemove{  
     public static void main(String args[]){  

        Student s1=new Student(1,"Roopa", "ECE");  
        Student s2=new Student(2,"Anjali", "CSE");  
        Student s3=new Student(3,"Keerthi", "IT");   
        Student s4=new Student(4,"Parthu", "ECE");  
        Student s5=new Student(5,"Rupali", "ECE");    
        Student s6=new Student(6,"Mahi", "IT");  
        Student s7=new Student(7,"Valika", "CSE");     
      
        ArrayList al=new ArrayList();  
        al.add(s1);  
        al.add(s2);  
        al.add(s3);  
        al.add(s4);  
        al.add(s5);  
        al.add(s6);
        al.add(s7);  
        
         DeptRemove dr = new DeptRemove();
         
        System.out.println(" Which Dept You want to remove"); 
        Scanner in = new Scanner(System.in);
        String dept = in.nextLine();
        
        dr.deleteStudents(al,dept);
        dr.printStudentDetails(al);
    }
    void deleteStudents(List al,String dept){
        Iterator itr=al.iterator();  
        while (itr.hasNext()) {

           Student sdnt = (Student)itr.next();
           if (sdnt.Stdept.equals(dept))
           itr.remove();
        }
    } 
    
     
    void printStudentDetails(List al){
        Iterator itr=al.iterator();
        while(itr.hasNext()) {
          Student sdnt1= (Student)itr.next();
          System.out.println(sdnt1.Strollno+" "+sdnt1.Stname+" "+sdnt1.Stdept);	
        }	
    }
}

class Student{  
    int Strollno;  
    String Stname;  
    String Stdept;  
    Student(int Strollno,String Stname,String Stdept){  
      this.Strollno=Strollno;  
      this.Stname=Stname;  
      this.Stdept=Stdept;  
    }  
}  



