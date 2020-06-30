package com.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDaoImpl;
import com.entity.Employee;


public class SecurityFilter implements Filter {
	

    public SecurityFilter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html; charset=utf-8"); 
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("uname");
		String pass = request.getParameter("pass");
		System.out.println(name);
		System.out.println(pass);

		EmployeeDaoImpl empdao = new EmployeeDaoImpl();
		List<Employee> employees = empdao.getAllEmployees(); 
		
		boolean match = false;
		
		// finds username/password match in db
		for (Employee e : employees) {
			if (e.getName().equals(name) && e.getPassword().equals(pass)) {
				
				match = true;
				
				// creates session
				session.setAttribute("name", name);
				out.println("Hello " + session.getAttribute("name") + "!<br>");
				
				// redirect to UserAdd
				request.getRequestDispatcher("useradd.html").include(request, response);
				
			}
		}
		
		// executes if match wasn't found
		if (!match) {
			out.println("Unable to login<br>");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); // redirect back to prev page
			rd.include(request, response);
		}
		
//		if (name.equals("admin") && pass.equals("manager")) {
//			session.setAttribute("name", name);
//			out.println("Hello " + session.getAttribute("name") + "!<br>");
//			request.getRequestDispatcher("useradd.html").include(request, response);
//			
//		}
//		else {
//			out.println("Unable to login<br>");
//			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//			rd.include(request, response);
//		}
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
//		System.out.println("Hello from init");
	}

}
