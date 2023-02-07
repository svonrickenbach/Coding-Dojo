<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expense Details</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<h1>Expense Details</h1>
	
	<h3>Expense Name: <c:out value="${receipt.expense}"/></h3>
	
	<h3>Expense Description: <c:out value="${receipt.description}"/></h3>
	
	<h3>Vendor: <c:out value="${receipt.vendor}"/></h3>
	
	<h3>Amount Spent: <c:out value="${receipt.amount}"/></h3>
	
	<a href="/">Dashboard</a>


</body>
</html>