<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>You have visited the welcome page <c:out value="${count}"/> times!</p>
	<a href="/">Try Another Visit?</a>
	<br />
	<button><a href="by2">Increase the counter by 2!</a></button>
	<br />
	<button><a href="reset">Reset</a></button>
</body>
</html>