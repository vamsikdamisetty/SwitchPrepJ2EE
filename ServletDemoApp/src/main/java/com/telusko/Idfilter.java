package com.telusko;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Idfilter
 */
@WebFilter("/addAlien")
public class Idfilter implements Filter {

	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("In filter");
		
		HttpServletRequest req = (HttpServletRequest) request;
		int aid = Integer.parseInt(req.getParameter("aid"));
		
		if(aid > 0)
			chain.doFilter(request, response);
		else
			response.getWriter().print("Enter valid ID");;
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
