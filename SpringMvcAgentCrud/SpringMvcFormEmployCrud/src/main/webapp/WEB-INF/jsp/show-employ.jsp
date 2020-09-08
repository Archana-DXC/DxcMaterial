<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <h1>Employees List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Employ No</th>
			<th>Employ Name</th>
			<th>Department</th>
			<th>Designation</th>
			<th>Basic</th>
			<th>Edit</th>
			<th>Delete</th>
			</tr>

		<c:forEach var="employ" items="${list}">
				<tr>
			<td>
				${employ.empno}
			</td>
			<td>
				${employ.name}
			</td>
			<td>
				${employ.dept}
			</td>
			<td>
				${employ.desig}
			</td>
			<td>
				${employ.basic}
			</td>
			 <td><a href="editemploy/${employ.empno}">Edit</a></td>
    <td><a href="deleteemploy/${employ.empno}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="employForm">Add New Employee</a>
</body>
</html>