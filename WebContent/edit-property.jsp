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
	<form action = "editPropertyServlet" method = "post">
	<p style="background-color:tomato" align="center"> Web Housing Management </p>
	Property Name: <input type = "text" name = "name" value = "${propertyToEdit.name}">
	Address: <input type = "text" name = "address" value = "${propertyToEdit.address}">
	<input type = "hidden" name = "id" value ="${propertyToEdit.id}">
	<p></p>
	<input type = "submit" value= "Save Edited Property">
 	</form>
</div>
</body>
</html>