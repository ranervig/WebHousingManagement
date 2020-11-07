<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editing List</title>
<style>
	div#container	{
	width:850px;
	height: 390px;
	margin:auto;
	padding:10px;
	background-color:powderblue;	
	border:thin solid black;
	font-color: blue;
	}	
	h4 {text-align: center;}
</style>
</head>
<body>
<div id="container">
<form action = "editListDetailsServlet" method="post">
<input type ="hidden" name = "id" value= "${listToEdit.id}">
<p style="background-color:tomato" align="center"> Property Edit Page </p>

<p></p>
	Customer Name: <input type = "text" name = "customerName" value="${listToEdit.tenant.name}"><br />
	
	Lease Signing date: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}"> 
				<input type ="text" name = "day" placeholder="dd" size="4" value= "${date}">, 
				<input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}">
	Lease Start Date: <input type ="text" name = "month" placeholder="mm" size="4" value = "${month}">
				<input type ="text" name = "day" placeholder="dd" size="4" value= "${date}">,
				<input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}">

	Lease End Date: <input type ="text" name = "month" placeholder="mm" size="4" value = "${month}">
				<input type ="text" name = "day" placeholder="dd" size="4" value= "${date}">,
				<input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}">
				
	<p>Price per Month: <input type = "text" name = "aptNo" value="${listToEdit.tenant.rent}"> <br /></p>
	<p>Apartment No.: <input type = "text" name = "aptNo" value="${listToEdit.tenant.unit_number}"><br /></p>
	
	Available Properties:<br />
<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
 <option value = "${currentitem.name}">${currentitem.address} </option>
</c:forEach>
</select>
<br />
<p></p>
<input type = "submit" value="SAVE THE LIST">
</form>
<p></p>
<a href = "index.html">Go to Home Page.</a>
</div>
</body>
</html>