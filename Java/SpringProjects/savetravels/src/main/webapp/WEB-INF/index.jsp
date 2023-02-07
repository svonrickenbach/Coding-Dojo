<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Travels</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Save Travels</h1>
	<table id="table" class="table">
  		<tr>
            <th>Expense</th>
            <th>Vendor</th>
            <th>Amount</th>
            <th>Actions</th>
 		</tr>
  		<c:forEach var="receipt" items="${receipts}">
  			<tr>
    			<td><a href="/one/receipt/<c:out value="${receipt.id}"></c:out>"><c:out value="${receipt.expense}"></c:out></a></td>
    			<td><c:out value="${receipt.vendor}"></c:out></td>
    			<td><c:out value="${receipt.amount}"></c:out></td>
    			<td><a href="/receipt/${receipt.id}/edit">edit</a></td>
    			<td><form action="/receipt/${receipt.id}" method="post">
   						<input type="hidden" name="_method" value="delete">
    					<button>Delete</button>
					</form>
				</td>
    		</tr>
    	</c:forEach>
	</table>
	
	<h2>Add an expense:</h2>
	
	<form:form action="/receipt/create" method="post" modelAttribute="receipt">
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

</body>
</html>