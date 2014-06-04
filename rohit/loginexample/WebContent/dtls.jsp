<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Details Page</title>
</head>
<body>
	<%
		String flag = (String) session.getAttribute("islogin");
		if (flag.equals("false")) 
		{
			out.println("you are not logged in");
			out.println("<p>" + "<a href=" + "login.html"+">click here </a> to login</p>");
		}
		else 
		{
			out.println("<form action=" + "logout.jsp" + " >");
			out.println("<table align=" + "right" + ">");
			out.println("<tr>");
			out.println("<td>");
			String name1 = (String) session.getAttribute("name");
			out.println("logged in user " + name1);
			out.println("</td>");
			out.println("<td><input type=" + "submit" + " value="+ "logout" + " /></td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</form>");
			String dob = request.getParameter("dob");
			out.println("<b>Date Of Birth : </b>" + dob);
		}
	%>
</body>
</html>