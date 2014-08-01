package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientServlet extends HttpServlet{

	
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet started!!!");
	}
/*
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}*/

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("At dopost()...");
		Client client = Client.create();
		WebResource webresource = client.resource("http://localhost:8080/CRUDytb/rest/resource/display");
		
		ClientResponse clientresp = webresource.accept("text/html").get(ClientResponse.class);
		if(clientresp.getStatus() == 200){
			String output = clientresp.getEntity(String.class);
		}
		
		
	}

	/*@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		
	}*/

	
}
