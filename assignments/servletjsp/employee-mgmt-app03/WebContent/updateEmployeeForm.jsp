<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
<div class="container-fluid" style="background:#c2f0f0">
<h1 style="align:center">Update Employee</h1>
<hr>
<form action="EmployeeUpdate" method="post">
<!-- Id: <input type="text" name="id"><br><br> -->
Name: <input class="form-control" type="text" name="name"><br><br>
Designation: <input class="form-control" type="text" name="design"><br><br>
Department: <input class="form-control" type="text" name="dept"><br><br>
Country: <input class="form-control" type="text" name="country"><br><br>
<button class="btn btn-success" type="submit">UPDATE</button>
</form>
<br>
&nbsp
<br>
</div>

</body>
</html>