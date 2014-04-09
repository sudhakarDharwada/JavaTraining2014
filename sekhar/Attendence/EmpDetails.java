import java.sql.Date;
import java.sql.Time;


public class EmpDetails
{
	private int empid;
	private boolean status;
	private Date date;
	private Time time;
	
	public EmpDetails(int empid,boolean status,String date,String time)
	{
		this.empid=empid;
		this.time=Time.valueOf(time);
		this.date=Date.valueOf(date);
		this.status=status;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public void setId(int empid) {
		this.empid= empid;
	}
	public int getempId() {
		return this.empid;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return this.date;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}

