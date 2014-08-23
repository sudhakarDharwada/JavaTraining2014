package com.vl.calendar.event;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/events")
public class Event_Resource 
{
	Event_DAO dao = new Event_DAO();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Collection<CalendarEvent> getall()
	{
		return dao.getevents(1).values();
	}
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public CalendarEvent create(CalendarEvent event)
	{
		return dao.addevent(event, 1);
	}
	@PUT
	@Path("{id}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public CalendarEvent update(CalendarEvent event,@PathParam("id") int id)
	{
		return dao.updateevent(event, id);
	}
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") int id)
	{
		dao.deleteevent(id);
	}
	@Path("count")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String count()
	{
		return "5";
	}
}
