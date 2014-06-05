<%@page contentType="text/html" pageEncoding="UTF-8"%>


<% if(session.getAttribute("name")==null)
                     {
                     response.sendRedirect("login.jsp");
                    }

%>




 <% 
 
    String n= (String)session.getAttribute("name1");
 	String m= (String)session.getAttribute("fname1");
 	String p= (String)session.getAttribute("sex1");
 	String q= (String)session.getAttribute("state1");
 	
 	response.setContentType("text/html");
	out.print("<html>");
	 	out.print("<body bgcolor= pink>");
   out.print("<h1>People Who Are Registererd </h1>");
 	out.print("<h3>Student Name:</h3>"+n);
 	out.print("<h3>FathersName:</h3>"+m);
 	out.print("<h3>sex:</h3>"+p);
 	out.print("<h3>state:</h3>"+q);
  //  out.print("<h3>Education:</h3>");
	out.print("</body>");
    out.print("</html>");

 	%>






<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload Example in JSP and Servlet - Java web application</title>
    </head>
 
    <body bgcolor="skyblue"> 
            <form action ="Logout">      
  <h3> file has uploaded sucessfully</h3>
 <center> <input type="submit" value="logout"></center>              
    
</form>
</body>
</html>

  

