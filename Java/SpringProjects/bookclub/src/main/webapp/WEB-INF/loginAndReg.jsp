<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Registration</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Welcome!</h1>
	<h3>Join our growing community.</h3>
	<div class="left" >
        <div class="card">
            <h2 class="register">Register</h2>
            <form:form action="/register" method="post" modelAttribute="newUser">
  				<div class="form-group">
    				<form:label path="userName">User Name</form:label>
    				<form:errors path="userName"/>
    				<form:input type="text" path="userName" class="form-control"/>
  				</div>
  				<div class="form-group">
        			<form:label path="email">Email:</form:label>
        			<form:errors path="email"/>
    				<form:input type="text" path="email" class="form-control"/>
  				</div>
  				<div class="form-group">
    				<form:label path="password">Password:</form:label>
    				<form:errors path="password"/>
    				<form:input type="password" path="password" class="form-control"/>
  				</div>
  				<div class="form-group">
    				<form:label path="confirm">Confirm PW:</form:label>
    				<form:errors path="confirm"/>
    				<form:input type="password" path="confirm" class="form-control"/>
  				</div>
  				<input type="submit" value="Register" />
            </form:form>
        </div>
    </div>
    <div class="left" >
        <div class="card">
            <h2 class="login">Login</h2>
            <form:form action="/login" method="post" modelAttribute="newLogin">
  				<div class="form-group">
    				<form:label path="email">Email:</form:label>
    				<form:errors path="email"/>
    				<form:input type="email" path="email" class="form-control"/>
  				</div>
  				<div class="form-group">
    				<form:label path="password">Password:</form:label>
    				<form:errors path="password"/>
    				<form:input type="password" path="password" class="form-control"/>
  				</div>
  				<input type="submit" value="Login" />
            </form:form>
        </div>
    </div>
</body>
</html>