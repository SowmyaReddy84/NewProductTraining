<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of users</h2>
			</caption>
			<tr>
				<th>EmpID</th>
				<th>Contact No</th>
				<th>SupervisorName</th>
				<th>BusinessUnitName</th>
				<th>Approve</th>
			</tr>
			<c:forEach var="profile" items="${profilelist}">
				<tr>
					<td><c:out value="${profile.empId}" /></td>
					<td><c:out value="${profile.contactNo}" /></td>
					<td><c:out value="${profile.supervisorName}" /></td>
					<td><c:out value="${profile.businessUnitName}" /></td>
		 <td><input type="radio" name="approved" value="approved"> <br></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>