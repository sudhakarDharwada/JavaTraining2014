<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>


<head>
<title>user details</title>
<script type="text/javascript">


window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
window.onhashchange=function(){window.location.hash="no-back-button";}

	function textfield() {

		 var firstname = document.myform.firstname.value;
		if (firstname == "" || firstname == NaN) {
			alert("Please enter first name...");
			document.myform.firstname.focus();
			return false;
		} 
		
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
		if(pwd.length <=5){
			alert("password should be greater than 5 characters!!!");
			return false;
		}
		if(document.form.Bike.checked == true){
			alert("Box1 is checked");
			}
		
		 if( document.myform.Country.value == "-1" )
		   {
		     alert( "Please provide your country!" );
		     return false;
		   }
		 if ( ( document.myform.gender[0].checked == false ) && ( document.myform.gender[1].checked == false ) )
		 {
		 alert ( "Please choose your Gender: Male or Female" );
		 return false;
		 }
		 
		 if(!document.myform.tc.checked){
			 alert('You must agree to the terms first.');
			 return false
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
	<form action="storingtosession" method="post" name="myform"
		onsubmit="return(textfield());">
		<center>
			First name: <input type="text" name="firstname"><br>
			Last name: <input type="text" name="lastname"><br> Email
			Id:<input type="text" name="email" /><br> Password: <input
				type="password" name="pwd"><br> <input type="checkbox"
				name="vehicle" value="Bike">I have a bike<br> <input
				type="checkbox" name="vehicle" value="Car">I have a car <br>
			<input type="radio" name="gender" value="male">Male <input
				type="radio" name="gender" value="female">Female<br> <select
				name="Country">
				<option value="-1" selected>[choose yours]</option>
				<option value="INDIA">INDIA</option>
				<option value="UK">UK</option>
				<option value="USA">USA</option>
			</select> <input type="submit" value="details" onclick=" return textfield()"
				name="logout">
			<!-- <input type="submit" value="click!" onclick="textfield() name="submit" ">  -->
		</center>
</body>
</html>