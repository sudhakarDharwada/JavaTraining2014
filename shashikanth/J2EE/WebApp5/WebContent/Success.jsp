<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success Page</title>
</head>
<body bgcolor="gray">
<%String check=(String)session.getAttribute("login");
String name=(String)session.getAttribute("usrname");%>
<%
if(check.equals("false"))
{
	response.sendRedirect("Login.jsp");
}
else{ %>
<div align="right">
<form action="Logout.jsp" method="post">
  <input type="submit" value="Logout" />
</form>
</div>
<h3 align="center"><%=name%></h3><h3 align="center">Logged in successfully!!</h3> 
<div align="center">
<form action="LoginTime.jsp" method="post">
<input type="submit" value="show log in time">
</form>
</div>
<%} %>
</body>
</html>