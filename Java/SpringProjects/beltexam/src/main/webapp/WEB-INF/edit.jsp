<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a New TV Show</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<h1><c:out value="${show.title}" /></h1>
	<form:form action="/shows/${show.id}" method="post" modelAttribute="show">
	<input type="hidden" name="_method" value="put" />
  		<div class="form-group">
    		<form:label path="title">Title</form:label>
    		<form:errors path="title"/>
    		<form:input type="text" path="title" class="form-control"/>
  		</div>
  		<div class="form-group">
        	<form:label path="network">Network</form:label>
        	<form:errors path="network"/>
    		<form:input type="text" path="network" class="form-control"/>
  		</div>
  		<div class="form-group">
    		<form:label path="description">Description</form:label>
    		<form:errors path="description"/>
    		<form:textarea path="description" class="form-control" cols="30" rows="10"></form:textarea>
  		</div>
  		<form:input type="hidden" path="user" value="${userId}"/>
  		<form:errors path="user"/>
  		<input type="submit" class="btn btn-primary" value="submit"/>
  		<a href="/shows" class="btn btn-danger">Cancel</a>
  		<a href="/shows/<c:out value="${show.id}" />/delete" class="btn btn-danger">Delete</a>
	</form:form>
	
</body>
</html>
