<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <p>
		The Site Under Construction...
	</p>
	<h1>Edit Employee</h1>
       <form:form action="/SpringMvcFormEmployCrud/employ/editsave">  
      	<table >  
      	<tr>
      	<td>Employ No</td>  
         <td><form:input  path="empno" readonly="readonly" /></td>
         </tr> 
         <tr>  
          <td>Name : </td> 
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>
         	<td>Department</td>
         	<td>
         		<form:input path="dept"/>
         	</td>
         </tr>
         <tr>  
          <td>Designation :</td>  
          <td><form:input path="desig" /></td>
         </tr> 
         <tr>  
          <td>Basic :</td>  
          <td><form:input path="basic" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
</body>
</html>