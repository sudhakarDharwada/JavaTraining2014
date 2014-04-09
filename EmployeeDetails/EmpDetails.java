import java.util.Date;

public class EmpDetails {
	public EmpDetails(int empid, String status, Date date) {
		super();
		this.empid = empid;
		this.status = status;
		this.date = date;
	}
	private int empid;
	private String status;
	private Date date;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getTime() {
		return date;
	}
	public void setTime(Date date) {
		this.date = date;
	}

}
