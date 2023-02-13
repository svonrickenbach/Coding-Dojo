<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Person</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>New Person</h1>
	<form:form action="/person/create" method="post" modelAttribute="person">
  		<div class="form-group">
    			<form:label path="firstName">First Name:</form:label>
    			<form:errors path="firstName"/>
    			<form:input type="text" path="firstName" class="form-control"/>
  		</div>
  		<div class="form-group">
        		<form:label path="lastName">Last Name:</form:label>
        		<form:errors path="lastName"/>
    			<form:input type="text" path="lastName" class="form-control"/>
  		</div>
  		<button type="submit" class="btn btn-default">Submit</button>
	</form:form>

</body>
</html>
