public class EmpDetails {
	public EmpDetails(int empid, String status, int time) {
		super();
		this.empid = empid;
		this.status = status;
		this.time = time;
	}
	private int empid;
	private String status;
	private int time;
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
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}

}
