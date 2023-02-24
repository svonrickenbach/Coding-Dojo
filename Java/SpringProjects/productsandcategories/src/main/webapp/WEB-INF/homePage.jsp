<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1 class = "text-center mt-4 mb-5">Home Page</h1>
	<div class = "m-4 border-bottom border-dark">
		<a href="/product" class="d-block">New Product</a>
		<a href="/category" class="d-block mt-2 mb-4">New Category</a>
	</div>
	<div class="m-4">
		<table class="table table-bordered border-dark">
  			<thead>
    			<tr>
      				<th class="text-center fs-3">Products</th>
      				<th class="text-center fs-3">Categories</th>
    		</tr>
  			</thead>
  			<tbody>
    			<tr>
      				<td scope="row" class="text-center">
      					<ul>
      						<c:forEach var = "product" items ="${products}">
								<li>
									<a href="product/<c:out value="${product.id}"/>"><c:out value="${product.name}"/></a>
								</li>    			
      						</c:forEach>
      					</ul>
      				</td>
      				<td class="text-center">
      					<ul>
      						<c:forEach var = "category" items ="${categories}">
      							<li>
									<a href="category/<c:out value="${category.id}"/>"><c:out value="${category.name}"/></a>   
								</li> 			
      						</c:forEach>
      					</ul>
      				</td>
   	 			</tr>
  			</tbody>
		</table>
	</div>
</body>
</html>