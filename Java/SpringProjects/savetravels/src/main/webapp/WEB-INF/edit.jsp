<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Expense</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Edit Expense</h1>

	<form:form action="/receipt/${receipt.id}/edit" method="post" modelAttribute="receipt">
		<input type="hidden" name="_method" value="put" />
  		<div class="form-group">
    		<form:label path="expense">Expense</form:label>
    		<form:errors path="expense"/>
    		<form:input type="text" path="expense" class="form-control"/>
  		</div>
  		<div class="form-group">
        	<form:label path="vendor">Vendor</form:label>
        	<form:errors path="vendor"/>
    		<form:input type="text" path="vendor" class="form-control"/>
  		</div>
  		<div class="form-group">
    		<form:label path="amount">Amount</form:label>
    		<form:errors path="amount"/>
    		<form:input type="number" step="0.01" path="amount" class="form-control"/>
  		</div>
  		<div class="form-group">
    		<form:label path="description">Description</form:label>
    		<form:errors path="description"/>
    		<form:textarea path="description" cols="30" rows="10"  class="form-control"></form:textarea>
  		</div>
  		<button type="submit" class="btn btn-default">Submit</button>
	</form:form>
	
	<a href="/">Go Back</a>
</body>
</html>