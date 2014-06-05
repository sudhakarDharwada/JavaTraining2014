<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>output</title>


<script>
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
window.onhashchange=function(){window.location.hash="no-back-button";}
</script> 

<header>
        <jsp:include page="header.jsp"/>
    </header>
    
    
</head>
<body>

<% 

//HttpSession session = request.getSession(false);
if(session.getAttribute("fname") == null ){
	
	RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.html");
    
    out.println("<font color=red>you are not loggedin. Login!!!</font>");
    System.out.println("you are not loggedin ....pls login");
    //rd.include(request, response);
	response.sendRedirect("home.html");
}
if (session == null) {

	out.println("sessiong checking");
	System.out.println("sessiong checking");
    response.sendRedirect("error.html");
}
%>


<%

 HttpSession session1 = request.getSession(false); 
out.println(session.getAttribute("fname"));
out.println(session.getAttribute("lname"));
out.println(session.getAttribute("email"));
out.println(session.getAttribute("vehicle"));
out.println(session.getAttribute("country"));

%>
<form action="logoutservlet" method="post" name="logoutform" >
	<center>
	<input type="submit" value="logout!"  name="logout" >
	</center>
	</form>
</body>
</html>