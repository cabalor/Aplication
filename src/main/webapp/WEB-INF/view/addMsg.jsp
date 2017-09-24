<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Massages</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="main">Main Site</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="main">Strona glowna</a></li>
			<li><a href="logout">wloguj</a></li>
		</ul>
	</div>
	</nav>
	<div class="contrainer">
		<form:form modelAttribute="post" method="post">
			<form:errors path="*" />
			<div class="form-group">
			<p><form:label path="user">User</form:label>
				<form:select path="user" items="${users}" itemLabel="name" itemValue="id"></form:select></p>
				<p><form:label for="comment" path="title">treść wiadomości</form:label>
				<form:textarea id="comment" rows="9" path="title" /></p>
			</div>
			<button type="submit" class="btn btn-default">wyslij wiadmość</button>
		</form:form>
	</div>
</body>
</html>