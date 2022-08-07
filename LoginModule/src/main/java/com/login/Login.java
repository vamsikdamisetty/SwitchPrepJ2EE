package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		if(uname.equals("vamsik") && pass.equals("1234")) {
			HttpSession session = req.getSession();
			session.setAttribute("uname", uname);
			resp.sendRedirect("welcome.jsp");
		}else {
			resp.sendRedirect("login.jsp");
		}
	}	
}
