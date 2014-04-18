package fileobjectread;

import java.sql.Time;
import java.sql.Date;

public class Student
{
	int id;
	Date date;
	Time time;
	boolean flag;
	public Student(String date,String time,String flag)
	{
		this.time=Time.valueOf(time);
		this.date=Date.valueOf(date);
		this.flag=Boolean.parseBoolean(flag);
	}
	public Student(int id,String time,String flag)
	{
		this.id=id;
	   	this.time=Time.valueOf(time);
		this.flag=Boolean.parseBoolean(flag);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

