<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Profile Details form</h1>
	<div class="ex">
		<form action="ProfileController" method="post">
			<table style="with: 50%">
				<tr>
					<td> EmployeeId</td>
					<td><input type="number" name="empId" required/></td>
				</tr>
				<tr>
					<td>ContactNo</td>
					<td><input type="text" name="contactNo" required/></td>
				</tr>
				<tr>
					<td>City</td>
					<td><input type="text" name="cityName" required/></td>
				</tr>
				<tr>
					<td>Qualification</td>
					<td><input type="text" name="qualification" /></td>
				</tr>
				<tr>
					<td>SupervisorName</td>
					<td><input type="text" name="supervisorName" /></td>
				</tr>
				<tr>
					<td>BusinessUnitName</td>
					<td><input type="text" name="businessUnitName" /></td>
				</tr>
			</table>
			<input type="submit" value="save" />
		</form>
	</div>
</body>

</html>