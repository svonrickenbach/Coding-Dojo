<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${category.name}"></c:out></title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1 class = "text-center mt-4 mb-5"><c:out value="${category.name}"></c:out></h1>
	<div class = "m-4 border-bottom border-dark">
		<a href="/" class="d-block mt-2 mb-4">Home</a>
	</div>
    <div class= "border-bottom border-dark m-4">
    	<h2>Categories</h2>
    	<ul>
      		<c:forEach var = "product" items ="${assignedProducts}">
      			<li>
					<a href="category/<c:out value="${product.id}"/>"><c:out value="${product.name}"/></a>   
				</li> 			
      		</c:forEach>
      	</ul>
    </div>
    <div class = "m-4">
    	<form action="/category/${id}" method="post">
    		<h3>Add Product:</h3>
    		<select name="productId" id="categoryId" class="input d-grid gap-2">
    			<c:forEach var="product" items="${unassignedProducts}">
    				<option value="${product.id}">${product.name}</option>
    			</c:forEach>
    		</select>
    		<input type="submit" class="button btn-primary" value="Add"/>
    	</form>
    </div>
</body>
</html>