<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Broker</title>
<link rel="stylesheet" type="text/css" href="/css/dashboard.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="header">
		<div class="left">
			<h3>Hello! <c:out value="${user.userName}" />. Welcome to..</h3>
			<h1>The Book Broker!</h1>
			<p>Available Books to Borrow</p>
		</div>
		<div class="right">
			<a href="/logout">logout</a>
			<a href="/books">back to the shelves</a>
		</div>
	</div>
	<div class="main">
		<table class="table">
	  		<tr>
	            <th>ID</th>
	            <th>Title</th>
	            <th>Author Name</th>
	            <th>Owner</th>
	            <th>Actions</th>
	 		</tr>
	  		<c:forEach var="book" items="${books}">
	  		<c:if test = "${book.borrower == null}">
	  			<tr>
	    			<td><c:out value="${book.id}"></c:out></td>
	    			<td><a href="/books/<c:out value="${book.id}"></c:out>"><c:out value="${book.title}"></c:out></a></td>
	    			<td><c:out value="${book.authorName}"></c:out></td>
	    			<td><c:out value="${book.user.userName}"></c:out></td>
	    			<td>
	    				<c:if test = "${user != book.user}">
	    					<a href="/bookmarket/<c:out value="${book.id}"></c:out>/borrow">borrow</a> 
	    				</c:if>
	    				<c:if test = "${user == book.user}">
	    					<a href="/books/<c:out value="${book.id}"></c:out>/edit">Edit |</a>
	    					<a href="/books/<c:out value="${book.id}"></c:out>/delete">Delete</a>
	    				</c:if>
	    			</td>
	    		</tr>
	    	</c:if>
	    	</c:forEach>
		</table>
		<table class="table">
	  		<tr>
	            <th>ID</th>
	            <th>Title</th>
	            <th>Author Name</th>
	            <th>Owner</th>
	            <th>Actions</th>
	 		</tr>
	  		<c:forEach var="book" items="${borrowedBooks}">
	  			<tr>
	    			<td><c:out value="${book.id}"></c:out></td>
	    			<td><a href="/books/<c:out value="${book.id}"></c:out>"><c:out value="${book.title}"></c:out></a></td>
	    			<td><c:out value="${book.authorName}"></c:out></td>
	    			<td><c:out value="${book.user.userName}"></c:out></td>
	    			<td>
	    				<a href="/bookmarket/<c:out value="${book.id}"></c:out>/return">return</a> 
	    			</td>
	    		</tr>
	    	</c:forEach>
		</table>
		
	</div>
</body>
</html>