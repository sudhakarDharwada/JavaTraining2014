<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>output</title>

<script>
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";
window.onhashchange=function(){window.location.hash="no-back-button";}
</script> 

<header>
  <jsp:include page="header.jsp"/>
</header>
    
</head>
<body>

<% 
//HttpSession session = request.getSession(false);
 if(session.getAttribute("email") == null ){
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
out.println(session.getAttribute("email"));

%>

</body>
</html>
