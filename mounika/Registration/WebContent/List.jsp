<% if(session.getAttribute("name")==null)
                     {
                     response.sendRedirect("login.jsp");
                    }

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<center><h1> Registration Form</h1></center>
</head>
<body bgcolor="skyblue">
<form action="Registration">
<tr>
<center>
<tr>
<td>Student Name<td>
 
 <input type ="text" name="Sname"></tr><br><br>

 <tr>
 <td>FatherName</td>
 <input type ="text" name="Fname"></tr><br><br>
<tr>

<td>Sex</td>
 <input type="radio" name="Sex" value="male"> Male
 <input type="radio" name="Sex" value="female"> Female
 </tr><br><br>


<tr>
<td>state</td>
<select name="state">
<option>Andhra Pradesh</option> 

<option> Karnataka </option>

<option> Maharasta </option>

<option> Kerala </option>

</select>
</tr>
<br><br>
<tr>
<td> Education</td>
 <input type="checkbox" name="group" value="BTech">BTech
 <input type="checkbox" name="group" value="MBA">MBA
 <input type="checkbox" name="group" value="MTECH">Mtech
</tr>
<br><br>
<tr>
<td>submit</td>
</tr>
<input type="submit"  value="submit the form">
<input type="reset"  value="reset the form">
</tr>
</center>
</form>
 </body>
</html>
