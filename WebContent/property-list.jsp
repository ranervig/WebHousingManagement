<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web Housing Management</title>

<style>
	div#container	{
	width:850px;
	margin:auto;
	padding:10px;
	background-color:powderblue;	
	border:thin solid black;
</style>
</head>
<body>
<div id="container">
	<form method="post" action ="navigationPropertyServlet">
		<table>
			<h4 style="background-color:tomato" align="center"> Property Housing Management</h4>
			<p> Please make sure you check the property you want to EDIT or DELETE</p>
			<c:forEach items="${requestScope.allPropertys}" var="currentproperty">
			<tr>
				<td><input type="radio" name="id" value="${currentproperty.id}"></td>
				<td>Name: ${currentproperty.name}</td>
			<td> || Address: ${currentproperty.address}</td>			
		</tr>
	</c:forEach>	
	</table>
	<p></p>
	<p></p>
	<input type = "submit" value = "edit" name="doThisToProperty">
	<input type = "submit" value = "delete" name="doThisToProperty">
	<input type = "submit" value = "add" name="doThisToProperty">
	</form>	
	<p>
		<a href = "index.html"> Go to home page</a>
	</p>
</div>
</body>
</html>