<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Burger Tracker</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Burger Tracker</h1>
	<table id="table" class="table">
  		<tr>
            <th>Burger Name</th>
            <th>Restaurant Name</th>
            <th>Rating (Out of 5)</th>
 		</tr>
  		<c:forEach var="burger" items="${burgers}">
  			<tr>
    			<td><c:out value="${burger.burgerName}"></c:out></td>
    			<td><c:out value="${burger.restaurantName}"></c:out></td>
    			<td><c:out value="${burger.rating}"></c:out></td>
    		</tr>
    	</c:forEach>
	</table>
	
	<h2>Add a Burger</h2>
	
	<form:form action="/burgers" method="post" modelAttribute="burger">
  		<div class="form-group">
    		<form:label path="burgerName">Burger Name</form:label>
    		<form:errors path="burgerName"/>
    		<form:input type="text" path="burgerName" class="form-control"/>
  		</div>
  		<div class="form-group">
        	<form:label path="restaurantName">Restaurant Name</form:label>
        	<form:errors path="restaurantName"/>
    		<form:input type="text" path="restaurantName" class="form-control"/>
  		</div>
  		<div class="form-group">
    		<form:label path="rating">Rating</form:label>
    		<form:errors path="rating"/>
    		<form:input type="number" path="rating" class="form-control"/>
  		</div>
  		<button type="submit" class="btn btn-default">Submit</button>
	</form:form>
	
	
</body>
</html>