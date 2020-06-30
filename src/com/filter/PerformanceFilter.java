package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// Filter applies to all servlets
@WebFilter("/*")
public class PerformanceFilter implements Filter {

	static int count = 0;
	
    public PerformanceFilter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8"); 
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		if (session.getAttribute("name") != null) {
			out.println("Hello " + session.getAttribute("name") + "!<br>");
		}
		
		long before = System.currentTimeMillis();

		chain.doFilter(request, response);
		
		long after = System.currentTimeMillis();
		
		out.println("Time elapsed: " + (after-before) + " ms");
		
		
	
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
