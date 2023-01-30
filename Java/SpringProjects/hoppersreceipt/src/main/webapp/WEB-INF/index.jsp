<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<h1>Customer Receipt: <c:out value="${name}"/></h1>
	<p>Item Name: <c:out value="${item}"/></p>
	<p>Price: <c:out value="${price}"/></p>
	<p>Description: <c:out value="${description}"/></p>
	<p>Vendor: <c:out value="${vendor}"/></p>
	
</body>
</html>