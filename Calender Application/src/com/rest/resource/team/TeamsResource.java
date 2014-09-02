package com.rest.resource.team;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.rest.entity.TeamUser;
import com.rest.model.TeamUserStore;

public class TeamsResource {
	@Context
	UriInfo uri;
	@Context
	Request request;
	String id;

	public TeamsResource(UriInfo uri,Request request,String id){
		this.id=id;
		this.uri=uri;
		this.request=request;
	}
	@GET
	@Produces(MediaType.TEXT_XML)
	public TeamUser getInfo(){
		TeamUser team=(TeamUser) TeamUserStore.DataRetrive().get(id);
		return team;
	}
	@DELETE
	public void getDelete(){
		TeamUser contact=(TeamUser)TeamUserStore.DataDelete(id);
		/*if(contact==null)
			throw new RuntimeException("Delete"+id+"Not Found");*/
	}
	@PUT
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void getUpdate(TeamUser team){
		System.out.println(team.getDesignation()+" "+team.getMobile_number()+" "+team.getId());
		TeamUserStore.DataUpdate(team); 
		
	}
	
}