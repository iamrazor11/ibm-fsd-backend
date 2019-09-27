<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid" style="background:#c2f0f0">
<h1 style="align:center">Add Employee</h1>
<form action="EmployeeController" method="post">
Id: <input class="form-control" type="text" name="id"><br><br>
Name: <input class="form-control" type="text" name="name"><br><br>
Designation: <input class="form-control" type="text" name="design"><br><br>
Department: <input class="form-control" type="text" name="dept"><br><br>
Country: <input class="form-control" type="text" name="country"><br><br>
<button class="btn btn-success" type="submit">ADD</button>
</form>
<br>
</div>

</body>
</html>