/* program to delete a particular student from the list depending up on the department*/
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.List;
class ArrayListExample{
	public static void main(String[] args)
	{
		List<StudentDetails> studentList = new ArrayList<StudentDetails>();
		studentList.add(new StudentDetails(1,"Mounika","IT"));
		studentList.add(new StudentDetails(2,"Mouni","CSE"));
		studentList.add(new StudentDetails(3,"Nandini","EEE"));
		studentList.add(new StudentDetails(4,"Nandu","IT"));
		System.out.println("Enter number of students to add: ");
		Scanner input = new Scanner(System.in);//for reading new students
        int countStudents = input.nextInt();
        for (int i = 0; i < countStudents; i++) {
			StudentDetails newStudents = new StudentDetails();
			System.out.println("Enter details for student: " + (i + 1));
			System.out.println("Enter id: ");
            newStudents.setStudentId(input.nextInt());
            System.out.println("Enter name: ");
            newStudents.setStudentName(input.next());
            System.out.println("Enter department: ");
            newStudents.setStudentDepartment(input.next());
            studentList.add(newStudents);
		}
		System.out.println(studentList.size());
		System.out.println("Enter the dept which you want to remove");
		String dept=input.next();
		ArrayListExample arrayList=new ArrayListExample();
		arrayList.deletingStudents(studentList,dept);
		arrayList.printStudentDetails(studentList);
		
	}	
	void deletingStudents(List studentList,String dept)
	{
		Iterator<StudentDetails> it = studentList.iterator();//for deleting a particular department people
		while (it.hasNext()) {
			StudentDetails sd = it.next();
			if (sd.getStudentDepartment().equals(dept))
				it.remove();
		} 
	}	
	void printStudentDetails(List studentList)
	{
		Iterator<StudentDetails> ir=studentList.iterator(); //printing all the details
		while(ir.hasNext()) {
			StudentDetails sd1= ir.next();
			System.out.println(sd1);	
		}		 
	}

}
