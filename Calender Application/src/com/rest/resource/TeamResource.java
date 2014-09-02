package com.rest.resource;

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

import com.rest.entity.Team;
import com.rest.model.TeamStore;

@Path("/team")
public class TeamResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() throws SQLException{
		int count=TeamStore.DataRetrive().size();
		return String.valueOf(count);
	}
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Team> getContactsBrowser() throws SQLException {
		List<Team> team = new ArrayList<Team>();
		team.addAll(TeamStore.DataRetrive().values());
		return team; 
	}
	@POST
	@Produces(MediaType.TEXT_HTML)
	
	@Consumes(MediaType.APPLICATION_JSON)
	public void newContact(Team t) throws IOException{
		System.out.println("team store method called"+t.getCname());
		
		TeamStore.DataInsert(t);
		
	//	servletResponse.sendRedirect("../index.html");
	}
	@Path("{team}")
	public TeamsResource getContact(@PathParam("team") String tname){
		System.out.println("resource 1........................");
		return new TeamsResource(uriInfo,request,tname);
	}
}