<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Srona o rejestracji</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/main">Home</a></li>
      <li><a href="login">logowanie do projektu</a></li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
    </ul>
  </div>
</nav>
<form:form modelAttribute="user" method="post">
<form:errors path="*"/>
  <div class="form-group">
    <form:label path="firstName">First Name</form:label>
	<form:input path="firstName"/>
  </div>
  <div class="form-group">
    <form:label path="lastName">Last Name</form:label>
	<form:input path="lastName"/>
  </div>
  <div class="form-group">
    <form:label path="login">login</form:label>
	<form:input path="login"/>
  </div>
  <div class="form-group">
    <form:label path="password">password</form:label>
	<form:input type="password" path="password"/>
  </div>
  <div class="form-group">
    <form:label path="email">email</form:label>
	<form:input type="email" path="email"/>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form:form>

</body>
</html>