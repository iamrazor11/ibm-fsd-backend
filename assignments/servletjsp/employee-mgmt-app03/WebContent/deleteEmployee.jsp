<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Employee</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid" style="background:#c2f0f0">
<h1>Delete an Employee</h1>
<hr>
<form action="EmployeeDelete" method="post">
Enter the employee id to be deleted: <input class="form-control" name="id" type="number"><br>
<button class="btn btn-danger" type="submit">Delete</button> 
</form>
<br>
&nbsp
<br>
</div>

</body>
</html>