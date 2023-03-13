<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Book</title>
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="p-4 m-4">
	<div class="header d-flex justify-content-between">
		<h1><c:out value="${show.title}"/></h1>
		<a href="/shows">Back to Dashboard</a>
	</div>
	<table class="table">
		<tr>
			<td><h3>Posted By:</h3></td>
			<td><h3><c:out value="${show.user.name}"/></h3></td>
		</tr>
		<tr>
			<td>Network:</td>
			<td><c:out value="${show.network}"/></td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><c:out value="${show.description}"/></td>
		</tr>
	</table>
	<div class="border-bottom border-dark">
	<a href="/shows/<c:out value="${show.id}"/>/edit" class="btn btn-primary mb-4">Edit</a>
	</div>
		<div class="m-4">
		<table class="table table-bordered">
	  		<tr>
	            <th>Name</th>
	            <th>Rating</th>
	 		</tr>
	  		<c:forEach var="rating" items="${ratings}">
	  			<tr>
	    			<td><c:out value="${rating.user.name}"/></td>
	    			<td><c:out value="${rating.rating}"/></td>
	    		</tr>
	    	</c:forEach>
		</table>
	</div>
	<form:form action="/rating/${show.id}" method="post" modelAttribute="rating">
		<form:label path="rating">Leave a Rating:</form:label>
		<form:errors path="rating"/>
		<form:input type="number" path="rating"/>
		<input type="hidden" name="user" value="${userId}"/>
		<input type="hidden" name="show" value="${show.id}"/>
		<input type="submit" class="btn btn-primary" value="Rate!"/>
	</form:form>
</body>
</html>