<%@page import="java.io.PrintWriter"%>
<%@page import="com.entity.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.EmployeeDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Employees</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<style>
		body {margin: 50px 50px;}
	</style>
</head>
<body>
		<% 
		response.setContentType("text/html; charset=utf-8"); 
	
		
		// EmployeeDaoImpl object
		EmployeeDaoImpl empDao = new EmployeeDaoImpl();
		
		// getting list of all Employees from DB
		List<Employee> emplist = empDao.getAllEmployees();
		

		// Printing employee info in table
		out.println("<html><head><title>Employee Table</title></head>"
				+ "	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\r\n" 
				+ "<style>body {margin: 50px 50px;}</style>"
				+ "<body>");
		
		// body
		out.print("<br><br>");
		out.print("<table class='table' border='1' width='90%'");
		out.print("<thead class='thead-dark'><tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>"
				+ "Country</th></tr></thead><tbody>");
		for (Employee e : emplist) {
			out.print("<tr><td>" + e.getEmpId() + "</td><td>" + e.getName() + "</td><td>" + e.getPassword() + "</td>"
					+ "<td>" + e.getEmail() + "</td><td>" + e.getCountry() + "</td>");
			out.print("<td><a href='DeleteUser?id=" + e.getEmpId() +"'>delete</a></td>");
			out.print("<td><a href='UpdateUser?id=" + e.getEmpId() +"'>edit</a></td></tr>");
		}
		
		out.print("</tbody></table>");
		out.println("<br><br><a href=Logout>Logout</a>");
		
		out.println("</body></html>");
		
		%>
		
		
		
		
		
</body>
</html>