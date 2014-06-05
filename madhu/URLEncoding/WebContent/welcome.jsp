<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
<h1>visit again</h1>
</head>
<body>

<%String check=(String)session.getAttribute("login");
String name=(String)session.getAttribute("n1");%>
<%
if("false".equals(check)||name==null)
{
	response.sendRedirect("user.jsp");
}
else{ %>
<div align="right">
<form action="logout.jsp" method="post">
  <input type="submit" value="Logout" />
</form>
</div>

<h3 align="center"><%=name%></h3><h3 align="center">Logged in successfully!!</h3> 

<div align="center">

<form action="welcome.jsp" method="post">

<input type="submit" value="welcome">

</form>

</div>

<%} %>
</body>
</html>