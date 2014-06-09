<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contactus</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body><%
try{
HttpSession hs=request.getSession();
String name=hs.getAttribute("uname").toString();
if(name!=null){
    %>
    <table border="1" width="905" align="center">
        <tr height="200">
            <td>Head</td>
        </tr>
        <tr height="50">
            <td><div id="templatemo_menu">
                <ul>
                    <li><a href="home.jsp" class="current">Home</a></li>
                    <li><a href="profile.jsp">Profile</a></li>
                    <li><a href="Services.jsp">Services</a></li>
                    <li><a href="toDay.jsp">toDay</a></li>
                    <li><a href="Company.jsp">Company</a></li>
                    <li><a href="Contactus.jsp">Contact</a></li>
                    <li><a href="logout.jsp" class="last">Logout</a></li>
                </ul> 
            </div></td>
        </tr>
        <tr height="500">
            <td>Body</td>
        </tr>
        <tr height="50">
            <td>footer</td>
        </tr>
    </table><%
}
else{
	%>
    <h2>Session Expire <a href="Login.html">click here</a> to Login</h2>
    
    <%
    
    }
}
catch(Exception e){
	%>
    <h2>Session Expire <a href="Login.html">click here</a> to Login</h2>
    
    <%
}
    %>
</body>
</html>
