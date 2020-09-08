<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <h1>Add New Employee</h1>
       <form:form  action="saveEmploy">  
      	<table >  
      	<tr>
      		<td>Employ No : </td>
      		<td> <form:input path="empno"/>
      	</tr>
         <tr>  
          <td>Employ Name : </td> 
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>
          <th>Department</th>
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
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
     
</body>
</html>