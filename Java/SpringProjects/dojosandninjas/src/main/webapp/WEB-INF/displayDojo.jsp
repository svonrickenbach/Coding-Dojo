<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Dojo</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
		<table id="table" class="table">
  			<tr>
    			<th>First Name</th>
    			<th>Last Name</th> 
    			<th>Age</th>
 			</tr>
  			<c:forEach var="ninja" items="${dojo.ninjas}">
  				<tr>
    				<td><c:out value="${ninja.firstName}"></c:out></td>
    				<td><c:out value="${ninja.lastName}"></c:out></td>
    				<td><c:out value="${ninja.age}"></c:out></td>
    			</tr>
    		</c:forEach>
		</table>
	<a href="/">Home</a>
</body>
</html>