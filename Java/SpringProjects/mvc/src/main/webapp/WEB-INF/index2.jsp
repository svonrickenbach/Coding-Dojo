<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
</head>
<body>

	<h1><c:out value="${book.title}"/></h1>
	
	<h2>Description: <c:out value="${book.description}"/></h2>
	
	<h2>Language: <c:out value="${book.language}"/></h2>
	
	<h2>Number of Pages: <c:out value="${book.numberOfPages}"/></h2>
	
	<a href="/books">All Books</a>
	<a href="/books/new">Add a New Book</a>

</body>
</html>