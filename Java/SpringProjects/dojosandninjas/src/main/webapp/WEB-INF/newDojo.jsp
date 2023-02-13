<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Dojo</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>New Dojo</h1>
	<form:form action="/create/dojo" method="post" modelAttribute="dojo">
		<div class="form-group">
    			<form:label path="name">Name</form:label>
    			<form:errors path="name"/>
    			<form:input type="text" path="name" class="form-control"/>
  		</div>
  		<input type="submit" value="Submit"/>
  	</form:form>
  	
  	<a href="/ninja">Create a New Ninja</a>
</body>
</html>