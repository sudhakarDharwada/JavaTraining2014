import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class TextFileOperation {
	public static void main(String[] args) {
		List<EmployeeDetails> empList = new ArrayList<EmployeeDetails>();
		File inFile =null;
		if (0 < args.length) {
			inFile = new File(args[0]);	
			ReadingEmployeeDetails fr=new ReadingEmployeeDetails();
			fr.readingFile(inFile,empList);
			Scanner a=new Scanner(System.in);
			System.out.println("Enter 1 to find the no.of employee present on particular day \n 2 for printing swipe in details \n 3 for dispalying the working hours of an employee");
			int b=a.nextInt();
			switch(b){
					case 1:
						fr.noOfEmployees(empList);
						break;
					case 2:	
						fr.employeeLoginDetails(empList);
						break;
					case 3:
						fr.employeeWorkingHours(empList);
						break;
					default:
						System.out.println("please select a number");
			}
		}
		else
		{
			System.out.println("please enter a file name while running");
		}
	}
}

