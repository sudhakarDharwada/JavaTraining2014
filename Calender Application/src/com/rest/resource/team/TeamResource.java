package com.rest.resource.team;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jackson.annotate.JsonGetter;

import com.rest.entity.TeamUser;
import com.rest.model.TeamUserStore;



@Path("/teamuser")
public class TeamResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount(){
		System.out.print("getcount is called");
		int count=TeamUserStore.DataRetrive().size();
		return String.valueOf(count);
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<TeamUser> getContactsBrowser() {
		System.out.print("getcontactbrowser is called");
		List<TeamUser> team = new ArrayList<TeamUser>();
		team.addAll(TeamUserStore.DataRetrive().values());
		System.out.println(team);
		return team; 
	}
	
	@SuppressWarnings("unchecked")
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_JSON)
	public void newContact(TeamUser user,@Context HttpServletResponse servletResponse) throws IOException, SQLException{
		System.out.println(user);
		TeamUserStore.DataInsert(user);
	}
	
	@Path("{teamuser}")
	public TeamsResource getContact(@PathParam("teamuser")String id){
		return new TeamsResource(uriInfo,request,id);
	}

}