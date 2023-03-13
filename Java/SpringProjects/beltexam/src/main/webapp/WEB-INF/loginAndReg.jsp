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
    <div class="container-fluid d-flex justify-content-center align-items-center">
        <div class="col-md-6">
            <h1 class="text-primary text-center">TV Show Database</h1>
            <div class="row">
                <div class="col-md-6">
                    <h2 class="text-center mb-3">Register</h2>
                    <form:form action="/register" method="post" modelAttribute="newUser">
                        <div class="form-group">
                            <form:label path="name">Name:</form:label>
	    					<form:errors path="name"/>
	    					<form:input type="text" path="name" class="form-control"/>
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
                        <button type="submit" class="btn btn-primary">Register</button>
                    </form:form>
                </div>
                <div class="col-md-6">
                    <h2 class="text-center mb-3">Login</h2>
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
                        <button type="submit" class="btn btn-primary">Login</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>