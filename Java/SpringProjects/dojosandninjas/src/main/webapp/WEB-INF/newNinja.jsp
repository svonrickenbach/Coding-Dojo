<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/create/ninja" method="post" modelAttribute="ninja">
		<div class="form-group">
			<form:select path="dojo">
        		<c:forEach var="oneDojo" items="${dojos}">
            		<form:option value="${oneDojo.id}" path="dojo">
                		<c:out value="${oneDojo.name}"/>
                		<%-- <input type="hidden" name="dojoId" value="${oneDojo.id}"/> --%>
            		</form:option>
        		</c:forEach>
    		</form:select>
    	</div>
  		<div class="form-group">
    			<form:label path="firstName">First Name:</form:label>
    			<form:errors path="firstName"/>
    			<form:input type="text" path="firstName" class="form-control"/>
  		</div>
  		<div class="form-group">
    			<form:label path="lastName">Last Name:</form:label>
    			<form:errors path="lastName"/>
    			<form:input type="text" path="lastName" class="form-control"/>
  		</div>
  		  		<div class="form-group">
    			<form:label path="age">Age:</form:label>
    			<form:errors path="age"/>
    			<form:input type="text" path="age" class="form-control"/>
  		</div>
  		<input type="submit" value="Submit"/>
	</form:form>
	
	<a href="/">Add a New Dojo</a>
</body>
</html>