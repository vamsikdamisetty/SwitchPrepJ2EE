<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Form</title>
</head>
<body>
	<!-- <form action="tutorials/getTutorial.action" method="post">
		<input type="text" name = "language">
		<input type="submit">
	</form>
	 -->
	
	<s:form action="tutorials/getTutorial">
		<s:textfield label="Enter the language to search tutorials:" key="language" />
		<s:submit/>
	</s:form>	
</body>
</html>