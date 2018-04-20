<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<div>${messages.success}</div>
<%-- Welcome ${request.getAttribute("empId)} --%>
<form name ="form1" action ="ValidateServlet"/>  
<table>  
<tr>  
<td>EmployeeId</td>  
<td><input type ="number" name="username"/></td>  <td>${messages.EmployeeId}</td>
</tr>  
<tr>  
<td>password</td>  
<td><input type = "password" name = "password"/></td>  <td>${messages.password}</td>
</tr>  
<tr>
<td>Role</td>
<td>
<select name="role">
<option value="HR">HR</option>
<option value="Employee"  selected="selected">Employee</option>
<option value="Employer">Employer</option>
</select>
</td>

</tr>
<tr>  
<td><input name="submit" type="submit" value ="submit"/></td></tr>  
</table>  
New User Register Here :<a href="register.jsp">register</a>.
</form>  
</body>
</html>