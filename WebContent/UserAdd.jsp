<%@page import="com.entity.Employee"%>
<%@page import="com.dao.EmployeeDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Add</title>
</head>
<body>

	<%
	int id = 0; // will be auto incremented in SQL
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String pass = request.getParameter("pass");
	String country = request.getParameter("country");
	
	// creating Employee and Dao objects
	EmployeeDaoImpl empDao = new EmployeeDaoImpl();
	Employee emp = new Employee(id, name, email, pass, country);

	
	// saving employee
	int i = empDao.save(emp);
	if (i==1) {
		out.println("<h4>Employee was added sucessfully!</h4><hr><br>");
		request.getRequestDispatcher("userload.jsp").include(request, response);
		
	}
	else {
		out.println("<h4 style=color:red>Unable to add employee!</h4>");
		request.getRequestDispatcher("useradd.html").include(request, response);
	}
	
	
	%>
</body>
</html>