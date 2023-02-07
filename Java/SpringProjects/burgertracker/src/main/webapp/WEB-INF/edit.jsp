<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Burger</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Edit Burger</h1>
	<form:form action="/burger/${burger.id}" method="post" modelAttribute="burger">
		<input type="hidden" name="_method" value="put" />
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
	
	<a href="/">Main Menu</a>

</body>
</html>