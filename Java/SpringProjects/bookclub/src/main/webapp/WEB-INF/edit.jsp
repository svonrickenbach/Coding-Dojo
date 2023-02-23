<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<h1>Edit Book</h1>
	<form:form action="/books/${book.id}" method="post" modelAttribute="book">
		<input type="hidden" name="_method" value="put" />
  		<div class="form-group">
    		<form:label path="Title">Title</form:label>
    		<form:errors path="title"/>
    		<form:input type="text" path="title" class="form-control"/>
  		</div>
  		<div class="form-group">
        	<form:label path="authorName">Author</form:label>
        	<form:errors path="authorName"/>
    		<form:input type="text" path="authorName" class="form-control"/>
  		</div>
  		<div class="form-group">
    		<form:label path="thoughts">My Thoughts</form:label>
    		<form:errors path="thoughts"/>
    		<form:textarea path="thoughts" class="form-control" cols="30" rows="10"></form:textarea>
  		</div>
  		<form:input type="hidden" path="user" value="${userId}"/>
  		<form:input type="hidden" path="borrower" value="${book.borrower.id}"/>
  		<button type="submit" class="btn btn-default">Submit</button>
	</form:form>
	<a href="/books/<c:out value="${book.id}"></c:out>/delete">Delete</a>
	
	<a href="/books">All Books</a>
</body>
</html>