<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>logout page</title>
</head>
<body>
	<%
		if(session.getAttribute("islogin")!=null)
		{ 
			session.invalidate();
		}
	%>
	<br>
	<br>
	<br>
	<h3 align="center">Logged Out Successfully</h3>
	<br>
	<p align="center">
		<a href="login.html">Click Here</a> to Login Again
	</p>
</body>
</html>