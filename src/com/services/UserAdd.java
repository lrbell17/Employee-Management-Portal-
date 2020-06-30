package com.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDaoImpl;
import com.entity.Employee;

/**
 * Servlet implementation class UserAdd
 */
@WebServlet("/UserAdd")
public class UserAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Setting char type
		response.setContentType("text/html; charset=utf-8"); 
		
		PrintWriter out = response.getWriter();
		
		// Grabbing vals from useradd.html
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
			out.println("<a href='userload.jsp'>View Employees</a>");
			
		}
		else {
			response.getWriter().println("<h4 style=color:red>Unable to add employee!</h4>");
		}
		
		
	}

}
