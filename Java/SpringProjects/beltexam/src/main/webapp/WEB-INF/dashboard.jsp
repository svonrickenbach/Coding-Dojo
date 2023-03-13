<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/dashboard.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="header">
		<div class="left">
			<h1>Welcome! <c:out value="${user.name}" /></h1>
		</div>
		<div class="right">
			<a href="/logout">logout</a>
		</div>
	</div>
	<div class="m-4">
		<table class="table table-bordered">
	  		<tr>
	            <th>Show</th>
	            <th>Network</th>
	            <th>Average Rating</th>
	 		</tr>
	  		<c:forEach var="show" items="${shows}">
	  			<tr>
	    			<td><a href="/shows/<c:out value="${show.id}"></c:out>"><c:out value="${show.title}"></c:out></a></td>
	    			<td><c:out value="${show.network}"></c:out></td>
					<c:set var="ratings" value="${show.userRatings}" />
					<c:set var="total" value="0" />
					<c:set var="count" value="${fn:length(ratings)}" />
					
					<c:forEach var="rating" items="${ratings}">
   				 		<c:set var="total" value="${total + rating.rating}" />
					</c:forEach>
					
					<c:set var="average" value="${total/count}" />
					<td><c:out value="${average}"/></td>
	    		</tr>
	    	</c:forEach>
		</table>
	</div>
		<a href="/shows/new" class="btn btn-primary">Add a Show</a>
</body>
</html>