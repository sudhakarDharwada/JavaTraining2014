<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LoginTime Page</title>
</head>
<body bgcolor="gray">
<%String name=(String)session.getAttribute("usrname");
String check=(String)session.getAttribute("login");
%>
<%
if(check.equals("false"))
{
	response.sendRedirect("Login.jsp");
}
else{ %>
<div align="right">
<form action="Logout.jsp">
  <input type="submit" value="Logout" />
</form>
</div>
<%=name %> Logged in at : <%=new Date().toLocaleString() %>
<% }%>
</body>
</html>