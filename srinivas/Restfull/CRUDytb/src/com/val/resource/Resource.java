package com.val.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/resource")
public class Resource {

	@POST
	@Path("update")
	public void addUser(){

		System.out.println("updating user...");
	}

	@GET
	@Path("display")
	public void getUser(){

		System.out.println("displaying user...");
		//return "hi";
	}

	@PUT
	@Path("add")
	public void updateUser(){

		System.out.println("adding user....");
	}

	@DELETE
	@Path("delete")
	public void deleteUser(){

		System.out.println("deleting user....");
	}
	
	@Path("special")
	public SpecialUser getSpecialUser(){
		return new SpecialUser();
	}
	

}
