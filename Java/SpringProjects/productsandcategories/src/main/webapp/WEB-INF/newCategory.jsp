<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1 class = "text-center mt-4 mb-5">Home Page</h1>
	<div class = "ms-4 border-bottom border-dark">
		<a href="/" class="d-block mt-2 mb-4">Home</a>
	</div>
        <form:form action="/category" method="post" modelAttribute="category" class = "m-4">
          <div class="form-group row">
            <form:label path="name" class="col col-form-label text-center border border-dark fs-3">Name:</form:label>
            <div class="col border border-dark align-items-center">
              <form:input type="text" path="name" class="form-control" id="name" />
              <form:errors path="name" />
            </div>
          </div>
          <div class="form-group row">
            <div class="d-grid gap-2">
              <button type="submit" class="btn btn-primary border border-dark">Submit</button>
            </div>
          </div>
        </form:form>
</body>
</html>