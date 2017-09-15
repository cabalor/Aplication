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
			<li><a href="main">Strona glowna</a></li>
			<li><a href="loged">twoja strona</a></li>
			<li><a href="logout">wloguj</a></li>
		</ul>
	</div>
	</nav>
	<h1>edytuj dane</h1>
	<div class="container">
		<form:form modelAttribute="logedUser" method="post"
			class="form-horizontal">
			<form:errors path="*" />
			<div class="form-group">
				<div class="form-group">
					<div class="col-sm-5">
						<form:label for="firstname" path="firstName">First Name</form:label>
						<form:input class="form-control" id="firstname" path="firstName"
							placeholder="enetr first name" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-5">
						<form:label for="lastname" path="lastName">Last Name</form:label>
						<form:input path="lastName" class="form-control" id="lastname"
							placeholder="enetr last name" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-5">
						<form:label path="email" for="exampleInputEmail1">Email address</form:label>
						<form:input path="email" type="email" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp"
							placeholder="Enter email" />
						<small id="emailHelp" class="form-text text-muted">We'll
							never share your email with anyone else.</small>
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>