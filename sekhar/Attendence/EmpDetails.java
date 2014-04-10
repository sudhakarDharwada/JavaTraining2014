public class EmpDetails
{
	private int empid;
	private boolean status;
	private String dates;
	public EmpDetails(int empid,boolean status,String dates)
	{
		this.empid=empid;
		this.dates=dates;
		this.status=status;
	}
	public void setId(int empid) {
		this.empid= empid;
	}
	public int getempId() {
		return this.empid;
	}
	public void setDate(String dates) {
		this.dates = dates;
	}
	public String getDate() {
		return this.dates;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}

