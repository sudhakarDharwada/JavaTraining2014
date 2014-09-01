package com.vl.calendar.profile;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserProfile 
{
	private String id;
	private String name;
	private String email;
	private String phone;
	private String designation;
	public UserProfile() {
		
	}
	public UserProfile(String id, String name, String email, String phone,
			String designation) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.designation = designation;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
