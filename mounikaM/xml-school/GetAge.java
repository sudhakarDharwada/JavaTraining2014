import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class GetAge 
{
	public static int ageCal(String str) throws ParseException
	{
		int age1;
		Date current=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date d2=dateFormat.parse(str);
		int years=current.getYear()-d2.getYear();
		int months=current.getMonth()-d2.getMonth();
		months=months+(years*12);
		return months;
		
	}
}
