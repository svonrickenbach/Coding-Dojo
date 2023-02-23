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
<body class="p-4">
	<div class="header">
		<h1><c:out value="${book.title}"/></h1>
		<a href="/books">back to the shelves</a>
	</div>
	<div class="subheader">
		<c:if test="${userId == book.user.id}">
			<h2>You read <c:out value="${book.title}"/> by <c:out value="${book.authorName}"/>.</h2>
			<h2>Here are your thoughts:</h2>
		</c:if>
		<c:if test="${userId != book.user.id}">
			<h2><c:out value="${book.user.userName}"/> read <c:out value="${book.title}"/> by <c:out value="${book.authorName}"/>.</h2>
			<h2>Here are <c:out value="${book.user.userName}"/>'s thoughts:</h2>
		</c:if>
	</div>
	<div class="main">
		<p><c:out value="${book.thoughts}"/></p>
	</div>
	<c:if test="${userId == book.user.id}">
		<button><a href="/books/<c:out value="${book.id}"></c:out>/edit">Edit</a></button>
	</c:if>
	<c:if test="${userId == book.user.id}">
		<form action="/books/${book.id}" method="post">
	   		<input type="hidden" name="_method" value="delete">
	    	<button>Delete</button>
		</form>
	</c:if>

</body>
</html>