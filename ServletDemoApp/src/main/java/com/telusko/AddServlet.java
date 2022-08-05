package com.telusko;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet{
	
	//Tomcat Creates the req objects
	
	/*
	 * service this method is generic will work for post,get
	 * if we want to restrict it only to work with post method us doPost instead
	 * 
	 * Everytime servelet is called service method is called based on the method type further doGet or doPost are callled
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		addNumber(req, resp);
	}
	
	/*
	 *we can have both the methods 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int sum = addNumber(req, resp);
		
		/*
		 * Pasing data to other servlet by adding attribute
		 * we receive in square servlet
		 */
//		req.setAttribute("sum", sum);
		HttpSession session = req.getSession();
		session.setAttribute("sum", sum);
		
		/*
		 * USing Cookie to pass CDSID
		 */
		
		Cookie cookie = new Cookie("CDSID", "VKRISHN9");
		resp.addCookie(cookie);
		resp.sendRedirect("square");
//		resp.sendRedirect("square?sum="+sum); //Query rewiting (To pass data)
		/*
		 * We are trying to Calling a Servlet from Servlet
		 */
//		RequestDispatcher rd = req.getRequestDispatcher("square");
//		rd.forward(req, resp);
	}
	
	int addNumber(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		int sum = num1 + num2;
		System.out.println("Sum is :" + sum);
		
		resp.getWriter().print(sum);
		return sum;
	}
}
