<%@page import="java.util.Date"%> Directive tag... @ is for Directive
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
    
<%@ include file = "Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Division is happening</title>
</head>
<body bgcolor="cyan">
	
	<p> Declarative tag... "! is for dont put it in service"
	We declare all the variables here</p>
	<%!
		int initVar = 10;
	%>
	
	<%
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	int divide=0;
	divide = num1/num2;
	/*try{
	
	}
	catch (ArithmeticException e){
		out.print("Error Occure while division");
	}*/
	out.println(divide + "<br>");
	out.println("\nVariable delared with declarative : "+initVar);
	Date d = new Date();
	out.print("<br>"+d);
	%>
	<%@ include file = "Header.jsp" %>
	<br>
	Printing declared variable with help of Expression tag <%= initVar%> 
</body>
</html>
<%@ include file = "Header.jsp" %>