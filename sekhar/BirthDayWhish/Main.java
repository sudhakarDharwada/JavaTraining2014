import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the file path:");
		String fname=sc.next();
		List<BirthDetails> birth;
		FileReader1 fr=new FileReader1();
		birth=fr.birthDetails(fname);
		Whish w=new Whish();
		w.calculate(birth);
	}
}
