<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class=header>
		<div class=left>
			<h1>Welcome! <c:out value="${user.userName}" /></h1>
			<p>Books from everyone's shelves:</p>
		</div>
		<div class=right>
			<a href="/logout">logout</a>
			<a href="/books/new">Add a book to my shelf!</a>
		</div>
	</div>
	<div class=main>
		<table id="table" class="table">
  		<tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author Name</th>
            <th>Posted By</th>
 		</tr>
  		<c:forEach var="books" items="${books}">
  			<tr>
    			<td><c:out value="${books.id}"></c:out></td>
    			<td><a href="/books/<c:out value="${books.id}"></c:out>"><c:out value="${books.title}"></c:out></a></td>
    			<td><c:out value="${books.authorName}"></c:out></td>
    			<td><c:out value="${books.user.userName}"></c:out></td>
    		</tr>
    	</c:forEach>
	</table>
	</div>
</body>
</html>