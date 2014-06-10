package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Registration
 */

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("Sname");
		String fname = request.getParameter("Fname");
		String sex = request.getParameter("Sex");
		String state = request.getParameter("state");
		String[] edu = request.getParameterValues("group");

		HttpSession session = request.getSession();
		session.setAttribute("name2", name);
		 System.out.println(session.getAttribute("name2"));
		session.setAttribute("fname1", fname);
		session.setAttribute("sex1", sex);
		session.setAttribute("state1", state);
		// session.setAttribute("edu1",edu[]);

		// response.setContentType("text/html");
		// out.print("<html>");
		// out.print("<body bgcolor= pink>");
		// out.print("<h1>People Who Are Registererd </h1>");
		// out.print("<h3>Student Name:</h3>"+name);
		// out.print("<h3>FathersName:</h3>"+fname);
		// out.print("<h3>sex:</h3>"+sex);
		// out.print("<h3>state:</h3>"+state);
		// out.print("<h3>Education:</h3>");
		// out.print("</body>");
		// out.print("</html>");
		// out.print("<ul>");
		//
		//
		// for(String s :edu)
		// {
		// out.print("<li>"+s+"</li>");
		// }
		// out.print("</ul>");
		// //String newURL =
		// response.encodeURL("/UploadFile/FileUploadHandler");
		// //System.out.println(name);
		// //System.out.println(fname);
		// //System.out.println(sex);
		// //System.out.println(state);
		// //System.out.println(edu);
		RequestDispatcher rd = request.getRequestDispatcher("upload.html");
		rd.forward(request, response);

	}

}
