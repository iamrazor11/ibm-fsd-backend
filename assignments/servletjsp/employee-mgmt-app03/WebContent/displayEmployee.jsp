<%@page import="com.employee.java.Employee"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Employees</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
<h1>
Employee Details
</h1>
<hr>
<% ArrayList<Employee> empList = new ArrayList<Employee>(); 
empList= (ArrayList<Employee>)request.getAttribute("empList");
//out.println("displayEmployee empList=",request.getAttribute("empList"));
//out.println(request.getAttribute("empList"));
	out.print("No of employees: " + empList.size());
	 %>
<div>
<table class="table table-striped table-bordered">
<thead class="bg-dark text-white">
<tr>
<td>Id</td><td>Name</td><td>Designation</td><td>Department</td><td>Country</td>
</tr>
</thead>
<tbody>
 <% for(Employee emp: empList) { %> 
			<tr>
				<td><%= emp.getId() %> </td>
				<td><%= emp.getName() %> </td>
				<td><%= emp.getDesign() %></td>
				<td><%= emp.getDept() %></td>
				<td><%= emp.getCountry() %></td>
				
			</tr>
			<%} %>
</tbody>
</table>
<br> <a href="index.jsp" class="btn btn-info">Go Home</a>
<br>
</div>
</div>
</body>
</html>