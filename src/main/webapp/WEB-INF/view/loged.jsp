<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>dzien dobry na stronie</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="main">Main Site</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="logout">logout</a></li>
			<li><a href="add">dodaj wiadomosc</a></li>
			<li><a href="userEdit">edytuj dane</a></li>
		</ul>
	</div>
	</nav>
	<div class="row">
		<div class="col-md-12">Witaj ${name}</div>
	</div>
	<c:if test="${not empty postList}">
		<c:forEach var="item" items="${postList}">
			<div class="container">
				<div class="row bs-callout bs-callout-primary">
					<div class="col col-md-1 col-sm-2"></div>
					<div class="col col-md-11 col-sm-10">
						${item.title}
						<h3 class="centered"></h3>
						<h6>
							<small>Dodane przez: <c:out value="${item.user.login}" />,
								Dnia: <fmt:formatDate value="${item.created}"
									pattern="dd/MM/YYYY" /></small>
						</h6>
						<h6>
							<small><button type="button"
									class="btn btn-primary btn-sm"
									onclick=" location.href = '<%=request.getContextPath() %>/edit/${item.id}';">
									edycja</a>
								</button>
								<button type="button" class="btn btn-danger btn-sm"
									onclick=" location.href = '<%=request.getContextPath() %>/del/${item.id}';">dilejtacja</button>
								</br></small>
						</h6>

					</div>
				</div>
			</div>
		</c:forEach>
	</c:if>
</body>
<script type="text/javascript"></script>
</html>