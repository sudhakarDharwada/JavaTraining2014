package com.rest.resource;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import com.rest.entity.Team;
import com.rest.model.TeamStore;

public class TeamsResource {
	@Context
	UriInfo uri;
	@Context
	Request request;
	String tname;

	public TeamsResource(UriInfo uri,Request request,String tname){
		this.uri=uri;
		this.request=request;
		this.tname=tname;
	}
	
	@DELETE
	public void getDelete(){
		Team contact=(Team) TeamStore.DataDelete(tname);
		if(contact==null)
			throw new RuntimeException("Delete"+tname+"Not Found");
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void getUpdate(Team team){
		System.out.println("data update..................");
		System.out.println(team.getClocation()+"   "+team.getCname()+"  "+team.getSequence());
		TeamStore.DataUpdate(team);
	}
}