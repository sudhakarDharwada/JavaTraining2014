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
		if (session.getAttribute("islogin")==null) {
			out.println("you are not logged in (or) session expired");
			out.println("<p>" + "<a href=" + "login.html"+ ">click here </a> to login</p>");
		}
		else 
		{ %>
	<form action="logout.jsp">
		<table align="right">
			<tr>
				<td>
					<%
						String name1 = (String) session.getAttribute("name");
						out.println("logged in user " + name1);
					%>
				</td>
				<td><input type="submit" value="logout" /></td>
			</tr>
		</table>
	</form>
	<%
		String dob = request.getParameter("dob");
		out.println("<b>Date Of Birth : </b>" + dob);
		}
	%>
</body>
</html>