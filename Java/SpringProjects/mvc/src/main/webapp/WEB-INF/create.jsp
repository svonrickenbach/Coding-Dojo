<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<h1>New Book</h1>
	<form:form action="/books" method="post" modelAttribute="book">
  		<div class="form-group">
    		<form:label path="Title">Title</form:label>
    		<form:errors path="title"/>
    		<form:input type="text" path="title" class="form-control"/>
  		</div>
  		<div class="form-group">
        	<form:label path="description">Description</form:label>
        	<form:errors path="description"/>
    		<form:input type="text" path="description" class="form-control"/>
  		</div>
  		<div class="form-group">
    		<form:label path="language">Language</form:label>
    		<form:errors path="language"/>
    		<form:input type="text" path="language" class="form-control"/>
  		</div>
  		<div class="form-group">
    		<form:label path="numberOfPages">Pages</form:label>
    		<form:errors path="numberOfPages"/>
    		<form:input type="number" path="numberOfPages" class="form-control"/>
  		</div>
  		<button type="submit" class="btn btn-default">Submit</button>
	</form:form>
	
	<a href="/books">All Books</a>
</body>
</html>