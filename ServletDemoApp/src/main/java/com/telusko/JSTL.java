package com.telusko;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telusko.beans.Student;

@WebServlet("/JSTL")
public class JSTL extends HttpServlet {

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			
			String name = "Vamsi Damisetti";
			
			req.setAttribute("label", name);
			
			Student s = new Student("Navin", 1);
			req.setAttribute("student", s);
			
			Student[] students = new Student[3];
			students[1]  = new Student("Ravi", 2);
			students[0]  = s;
			students[2]  = new Student("Baba", 3);
			
			req.setAttribute("students", students);
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("display.jsp");
			requestDispatcher.forward(req, resp);
		}
}
