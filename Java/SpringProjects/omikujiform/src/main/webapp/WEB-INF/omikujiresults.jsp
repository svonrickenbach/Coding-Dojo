<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Here's Your Omikuji!</h1>
	<div class="results">
		<p>In <c:out value="${number}"/> years, you will
			live in <c:out value="${cityName}"/> with
			<c:out value="${personName}"/> as your
			roommate, <c:out value="${hobby}"/> for a living.
			The next time you
			see a <c:out value="${livingThing}"/>, you will
			have good luck.
			Also, <c:out value="${niceMessage}"/>.
		</p>
	</div>
	<a href="/">Home</a>
</body>
</html>