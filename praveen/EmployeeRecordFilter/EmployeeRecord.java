package com.vlabs.employee.bean;

import java.util.Date;
/*Bean */
public class EmployeeRecord {
	private int Id;
	private String status;
	private Date d;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public EmployeeRecord(int Id, String status, Date d) {
		this.Id = Id;
		this.status = status;
		this.d = d;
	}

	@SuppressWarnings("deprecation")
	public boolean compareTo(Date date) {
		boolean status = false;
		if ((date.getDate()) == (this.d.getDate())
				&& ((date.getMonth()) == (this.d.getMonth()))
				&& ((date.getYear()) == (this.d.getYear() + 1900))) {
			status = true;
			return status;
		}
		else if (((date.getHours())==(this.d.getHours()))&&((date.getMinutes())==(this.d.getMinutes()))) {
			status=true;
			return status;
		}
		return status;
	}
	
}

