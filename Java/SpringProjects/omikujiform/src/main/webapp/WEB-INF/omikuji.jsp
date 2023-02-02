<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Send an Omikuji</h1>
	<form action='/submit' method="POST">
  		<div class="form-group">
  			<p><c:out value="${error}"/></p>
    		<label for="pickANumber">Pick any number from 5 to 25:</label>
    		<input type="number" name="number" id="pickANumber" class="form-control">
  		</div>
  		<div class="form-group">
    		<label>Enter the name of any city:</label>
    		<input type="text" name="cityName" class="form-control">
  		</div>
  		<div class="form-group">
    		<label>Enter the name of any real person:</label>
    		<input type="text" name="personName" class="form-control">
  		</div>
  		<div class="form-group">
    		<label>Enter professional endeavor or hobby:</label>
    		<input type="text" name="hobby" class="form-control">
  		</div>
  		<div class="form-group">
    		<label>Enter any type of living thing:</label>
    		<input type="text" name="livingThing" class="form-control">
  		</div>
  		<div class="form-group">
    		<label>Say something nice to someone:</label>
    		<textarea name="niceMessage" id="" cols="30" rows="10" class="form-control"></textarea>
  		</div>
  		<button type="submit" class="btn btn-default">Submit</button>
	</form>
</body>
</html>