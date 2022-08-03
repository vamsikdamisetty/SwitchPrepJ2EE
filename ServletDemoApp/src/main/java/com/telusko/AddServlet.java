package com.telusko;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		addNumber(req, resp);
	}
	
	void addNumber(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		int sum = num1 + num2;
		System.out.println("Sum is :" + sum);
		
		resp.getWriter().print(sum);
	}
}
