package com.vl.school.bean;

import java.util.Date;

public class Student {
	private String SName;
	private Date SDOB;
	private String SAddress;
	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		SName = sName;
	}
	public Date getSDOB() {
		return SDOB;
	}
	public void setSDOB(Date sDOB) {
		SDOB = sDOB;
	}
	public String getSAddress() {
		return SAddress;
	}
	public void setSAddress(String sAddress) {
		SAddress = sAddress;
	}
}
