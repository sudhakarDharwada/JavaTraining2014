import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class GetAge 
{
	public static long ageCal(String str) throws ParseException
	{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date d2=dateFormat.parse(str);
		return System.currentTimeMillis()-d2.getTime();
	}
}
