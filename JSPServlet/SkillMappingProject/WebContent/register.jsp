<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>

	<h1>Registration Form</h1>
	<div class="ex">
	
		<form action="RegisterationController" method="post">
			<table style="with: 50%">
			<tr>
			<font color="red""></font><td>${messages.Required}</td></font>
			</tr>
				<tr>
					<td>EmployeeId*</td>
					<td><input type="text" name="EmployeeId" /></td>
				</tr>
				<tr>
					<td>Name*</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>emailID*</td>
					<td><input type="text" name="emailID" /></td><td>${messages.emaiId}</td>
				</tr>
				<tr>
					<td>password*</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Role</td>
					<td>
					<select name="role">
						<option value="HR">HR</option>
						<option value="Employee" selected="selected">Employee</option>
						<option value="Employer">Employer</option>
					</select>
					</td>
				</tr>


			</table>
			<input type="submit" value="register" />
		</form>
	</div>
</body>
</html>