<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Customer List</title>
<style>
div#container	{
	width:850px;
	height: 500px;
	margin:auto;
	padding:10px;
	background-color:powderblue;	
	border:thin solid black;
	font-color: blue;
	}
</style>
</head>
<body>
<div id="container">
<form action = "createNewListServlet" method="post">
<p style="background-color:tomato" align="center"> Web Housing Management </p>

Tenant Name: <input type ="text" name = "tenantName"><br />
<p></p>
<p>Price per Month: <input type ="text" name = "price"><br /></p>

<p>Lease signing Date: <input type ="text" name = "month" placeholder="mm" size="4"> <input type ="text" name = "day" placeholder="dd" size="4">, <input type ="text" name = "year" placeholder="yyyy" size="4"></p>

Lease Start Date: <input type ="text" name = "month" placeholder="mm" size="4"> <input type ="text" name = "day" placeholder="dd" size="4">, <input type ="text" name = "year" placeholder="yyyy" size="4">

Lease End Date: <input type ="text" name = "month" placeholder="mm" size="4"> <input type ="text" name = "day" placeholder="dd" size="4">, <input type ="text" name = "year" placeholder="yyyy" size="4">

<p>Apartment No.: <input type = "text" name = "aptNo"><br /></p>

<p style="background-color:tomato" align="center">Available Property: </p><br />

<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
   <option value = "${currentitem.id}">${currentitem.name} | ${currentitem.address} </option>
</c:forEach>
</select>
<br />
<p></p>
<input type = "submit" value="Create List and Add Items">
</form>
<p><a href = "index.html">Go add new items instead.</a></p>
</div>
</body>
</html>