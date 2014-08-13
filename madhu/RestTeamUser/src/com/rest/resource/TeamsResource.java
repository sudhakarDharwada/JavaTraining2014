package com.rest.resource;

import javax.ws.rs.GET;
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
	/*@DELETE
	public void getDelete(){
		TeamUser contact=TeamUserStore.DataRetrive().remove(id);
		if(contact==null)
			throw new RuntimeException("Delete"+id+"Not Found");
	}
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response getUpdate(JAXBElement<TeamUser> team){
		TeamUser c=team.getValue();
		return getUpdateProcess(c);
	}
	private Response getUpdateProcess(TeamUser team) {
		Response res;
		if(TeamUserStore.getDetailes().containsKey(team.getId())) {
			res = Response.noContent().build();
		} else {
			res = Response.created(uri.getAbsolutePath()).build();
		}
		TeamUserStore.getDetailes().put(team.getId(), team);
		return res;
	}*/
}
