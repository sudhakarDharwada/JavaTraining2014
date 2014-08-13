package com.rest.resource.team;

import java.io.IOException;
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
	public String getCount(){
		int count=TeamStore.DataRetrive().size();
		return String.valueOf(count);
	}
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Team> getContactsBrowser() {
		List<Team> team = new ArrayList<Team>();
		team.addAll(TeamStore.DataRetrive().values());
		return team; 
	}
	@SuppressWarnings("unchecked")
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newContact(@FormParam("tname") String tname,
			@FormParam("cname")String cname,
			@FormParam("clocation")String clocation,
			@Context HttpServletResponse servletResponse) throws IOException{
		Team team=new Team(tname,cname,clocation);
		TeamStore.DataInsert().put(tname, team);
		
	//	servletResponse.sendRedirect("../index.html");
	}
	@Path("{team}")
	public TeamsResource getContact(@PathParam("team")String tname){
		return new TeamsResource(uriInfo,request,tname);
	}
}
