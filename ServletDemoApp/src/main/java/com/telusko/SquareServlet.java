package com.telusko;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/square")
public class SquareServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int sum = (int) req.getAttribute("sum");  //using get attribute
//		int sum = Integer.parseInt(req.getParameter("sum")); // from query rewriting
		
		//from session
		HttpSession session = req.getSession();
		int sum = (int) session.getAttribute("sum");
		session.removeAttribute("sum");
		System.out.println(session.getAttribute("sum"));
		
		/*
		 * Getting all cookie from req as cient could have multipe
		 */
		Cookie cookies[] = req.getCookies();
		
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("CDSID")) {
				resp.getWriter().println("Hello "+ cookies[i].getValue());
			}
		}
		
		resp.getWriter().print("Square is(Session) :"+sum*sum);
		resp.getWriter().print("\nHello to square");
	}
}
