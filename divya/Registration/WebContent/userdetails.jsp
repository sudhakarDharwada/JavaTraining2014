<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<head>
<title>user details</title>
<script type="text/javascript">

window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";
window.onhashchange=function(){window.location.hash="no-back-button";}

function textfield() {
  var email = document.myform.email.value;
  if(email == "" || email == NaN){
    alert("Please enter email id...")
    document.myform.email.focus();
    return false;
  }
  var pwd = document.myform.pwd.value;
  if(pwd == "" || pwd == NaN){
    alert("please enter password!!");
    return false;
  }
  if(pwd.length <=6){
    alert("password should be greater than 6 characters!!!");
    return false;
  }
  return( true );
		
}
	
</script>
<header>
  <jsp:include page="header.jsp"/>
</header>
</head>
<body>

<% 

//HttpSession session1 = request.getSession(false);
if (session == null) {

    response.sendRedirect("error.html");
}
%>
  <form action="storingtosession" method="post" name="myform" onsubmit="return(textfield());">
<center>
  Id:<input type="text" name="email" /><br> 
  Password: <input type="password" name="pwd"><br> 
  <input type="submit" value="details" onclick=" return textfield()" name="logout">
</center>
</body>
</html>
