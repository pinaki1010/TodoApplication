<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<title>My Login Page</title>
</head>
<body>
<%@include file="common/navigation.jspf"  %>
<div class="container">
<div>Welcome ${name}</div>
<hr>
<h1>Your Todos are</h1>

<table class="table">
	<thead>
		
		<th>subject</th>
		<th>description</th>
		<th>done</th>
		<th>localDate</th>
		<th> </th>
		<th></th>
	</thead>

	<tbody>

		<c:forEach items="${todos}" var="todos">
		<tr>
		
		<td>${todos.name}</td>
		<td>${todos.description}</td>
		<td>${todos.done}</td>
		<td>${todos.localDate}</td>
		<td><a href="delete-todo?id=${todos.id}" class="btn btn-warning">Delete</a></td>
		<td><a href="update-todo?id=${todos.id}" class="btn btn-success">Update</a></td>
		
		</tr>

		</c:forEach>
	</tbody>
</table>
<a href="add-todo" class="btn btn-success">Add Todo</a>
</body>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>


</html>