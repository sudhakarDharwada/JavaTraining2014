package com.val.resource;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;

public class SpecialUser {

	@PUT
	public void createSpecialUser(){
		
		System.out.println("createSpecialUser()....");
	}
	@GET
	public void getSpecialUser(){
		System.out.println("getSpecialUser()......");
	}
	
}
