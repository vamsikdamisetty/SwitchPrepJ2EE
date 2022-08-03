package com.telusko;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SquareServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int sum = (int) req.getAttribute("sum");
		int sum = Integer.parseInt(req.getParameter("sum"));
		resp.getWriter().print("Square is :"+sum*sum);
		resp.getWriter().print("\nHello to square");
	}
}
