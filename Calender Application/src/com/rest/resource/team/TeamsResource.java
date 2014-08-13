package com.rest.resource.team;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
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
		this.tname=tname;
		this.uri=uri;
		this.request=request;
	}
	@GET
	@Produces(MediaType.TEXT_XML)
	public Team getInfo(){
		Team team=(Team) TeamStore.DataRetrive().get(tname);
		return team;
	}
	/*@DELETE
	public void getDelete(){
		Team contact=TeamStore.getDetailes().remove(tname);
		if(contact==null)
			throw new RuntimeException("Delete"+tname+"Not Found");
	}
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response getUpdate(JAXBElement<Team> team){
		Team c=team.getValue();
		return getUpdateProcess(c);
	}
	private Response getUpdateProcess(Team team) {
		Response res;
		if(TeamStore.getDetailes().containsKey(team.getTname())) {
			res = Response.noContent().build();
		} else {
			res = Response.created(uri.getAbsolutePath()).build();
		}
		TeamStore.getDetailes().put(team.getTname(), team);
		return res;
	}*/
}
