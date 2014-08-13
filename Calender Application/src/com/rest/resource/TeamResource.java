package com.rest.resource;

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
		int count=TeamUserStore.DataRetrive().size();
		return String.valueOf(count);
	}
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<TeamUser> getContactsBrowser() {
		List<TeamUser> team = new ArrayList<TeamUser>();
		team.addAll(TeamUserStore.DataRetrive().values());
		return team; 
	}
	@SuppressWarnings("unchecked")
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newContact(@FormParam("id") String id,
			@FormParam("name")String name,@FormParam("email") String email,
			@FormParam("mobile_number") int mobile_number,
			@FormParam("designation") String designation,@FormParam("password") String password,
			@Context HttpServletResponse servletResponse) throws IOException{
		TeamUser team=new TeamUser(id,name,email,mobile_number,designation,password);
		TeamUserStore.DataInsert().put(id, team);
	//	servletResponse.sendRedirect("../index.html");
	}
	@Path("{teamuser}")
	public TeamsResource getContact(@PathParam("teamuser")String id){
		return new TeamsResource(uriInfo,request,id);
	}

}
