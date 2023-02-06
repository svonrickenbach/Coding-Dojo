<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
	<h1>All Books</h1>
	<table id="table" class="table">
  		<tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
 		</tr>
  		<c:forEach var="books" items="${books}">
  			<tr>
    			<td><c:out value="${books.id}"></c:out></td>
    			<td><a href="/books/<c:out value="${books.id}"></c:out>"><c:out value="${books.title}"></c:out></a></td>
    			<td><c:out value="${books.language}"></c:out></td>
    			<td><c:out value="${books.numberOfPages}"></c:out></td>
    		</tr>
    	</c:forEach>
	</table>

</body>
</html>