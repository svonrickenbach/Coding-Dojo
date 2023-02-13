<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New License</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>New License</h1>
	
	<form:form action="/license/create" method="post" modelAttribute="license">
		<div class="form-group">
			<form:select path="person">
        		<c:forEach var="onePerson" items="${persons}">
            		<form:option value="${onePerson.id}" path="person">
                		<c:out value="${onePerson.firstName}"/>
                		<c:out value="${onePerson.lastName}"/>
            		</form:option>
        		</c:forEach>
    		</form:select>
    	</div>
  		<div class="form-group">
    			<form:label path="state">State:</form:label>
    			<form:errors path="state"/>
    			<form:input type="text" path="state" class="form-control"/>
  		</div>
  		<div class="form-group">
        		<label for="expirationDate">Expiration Date:</label>
    			<input type="text" name="expirationDate" class="form-control"/>
  		</div>
  		<button type="submit" class="btn btn-default">Submit</button>
	</form:form>
	
</body>
</html>