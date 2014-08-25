package com.rest.resource;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.rest.entity.Team;
import com.rest.model.TeamStore;

public class TeamsResource {
	@Context
	UriInfo uri;
	@Context
	Request request;

	public TeamsResource(UriInfo uri,Request request){
		this.uri=uri;
		this.request=request;
	}
	/*@GET
	@Produces(MediaType.TEXT_XML)
	public Team getInfo(){
		Team team=(Team) TeamStore.DataRetrive().get(tname);
		return team;
	}*/
	@Path("delete")
	@DELETE
	@Consumes(MediaType.TEXT_PLAIN)
	public void getDelete(/*@PathParam("tname") String tname*/){
		System.out.println("delete resource gggggggggggggggggggggggggggggggggggggggg");
		/*Team contact=(Team) TeamStore.DataDelete(tname).remove(tname);
		if(contact==null)
			throw new RuntimeException("Delete"+tname+"Not Found");*/
	}
	/*
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
