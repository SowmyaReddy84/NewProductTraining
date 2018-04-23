<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Skills</title>
</head>
<body>
<h1>Skills Details form</h1>
	<div class="ex">
		<form action="SkillsController" method="post">
			<table style="with: 50%">
				<tr>
					<td> ProfileID</td>
					<td><input type="number" name="profileId" required/></td>
				</tr>
				<tr>
					<td>SkillName</td>
					<td><input type="text" name="skillName" required/></td>
				</tr>
				<tr>
					<td>Experience</td>
					<td><input type="text" name="experience" required/></td>
				</tr>
				
			</table>
			<input type="submit" value="save" />
			
		</form>
	</div>
</body>
</body>
</html>