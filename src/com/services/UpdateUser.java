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
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8"); 
		
		EmployeeDaoImpl empDao = new EmployeeDaoImpl();
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		Employee e = empDao.getEmployeeById(id);

		// Takes info from user via form, sends to doPost
		out.println("<html><head><title>Update User</title></head><body><h4>Update User:</h4>");
		out.print("<form action='UpdateUser' method='post'>");

		out.print("<input type='hidden' name='id' value='" + id + "'/>");
		out.print("Name:<input type='text' name='name'" + e.getName() + "'/><br><br>");
		out.print("Password:<input type='password' name='password'" + e.getPassword() + "'/><br><br>");
		out.print("Email:<input type='email' name='email'" + e.getEmail() + "'/><br><br>");
		out.print("Country:<input type='text' name='country'" + e.getEmail() + "'/><br><br>");

		out.print("<input type='submit' value='Edit & Save '/>");

		out.print("</form>");
		out.print("</body></html>");


	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeDaoImpl empDao = new EmployeeDaoImpl();
		
		// Extracting info from form in doGet:
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		Employee emp = new Employee(id, name, password, email, country);
		
		int i = empDao.update(emp);
		
		if (i==1) {
			response.sendRedirect("UserLoad");
		}
	}
}
