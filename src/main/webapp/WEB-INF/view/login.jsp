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
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="main">Main Site</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="main">Home</a></li>
			<li><a href="register">rejestrcja do projektu</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
		<form:form modelAttribute="loginUser" method="post"
			class="form-horizontal">
			<form:errors path="*" />
			<div class="form-group">
				<div class="form-group">
					<div class="col-sm-5">
						<form:label for="login" path="login">Login</form:label>
						<form:input value= "kraken" class="form-control" id="login" path="login"
							placeholder="enter your login here" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-5">
						<form:label for="password" path="password">Password</form:label>
						<form:input value="kraken" type="password" path="password" class="form-control"
							id="password" placeholder="enter your password here" />
					</div>
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</form:form>
	</div>
</body>
</html>