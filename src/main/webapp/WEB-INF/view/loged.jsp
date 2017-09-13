<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>dzien dobry na stronie</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="main">Strona</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="logout">logout</a></li>
      <li><a href="add">dodaj film</a></li>
    </ul>
  </div>
</nav>


<div class="row">
  <div class="col-md-12">Witaj ${name}  </div>
</div>

<p>
<c:forEach items="${postList}" var="item">
    ${item.title}<br> <button><a href="<%=request.getContextPath() %>/edit/${item.id}">edycja</a></button>   <button><a href="<%=request.getContextPath() %>/del/${item.id}">dilejtacja</a></button></br>
</c:forEach>
</p>




</body>
</html>