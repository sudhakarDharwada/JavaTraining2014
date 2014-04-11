package fileobjectread;

import java.sql.Time;
import java.sql.Date;

public class Studentiddtls
{
	Date date;
	Time time;
	boolean flag;
	public Studentiddtls(String date,String time,String flag)
	{
	   	this.time=Time.valueOf(time);
	    this.date=Date.valueOf(date);
	    this.flag=Boolean.parseBoolean(flag);
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time t) {
		this.time = t;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public void setDate(Date d) {
	    this.date = d;
	}
	public Date getDate() {
	    return this.date;
	}
}

