<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Success!
<br>
Business service executed
<br>
<!-- property tag is used to fetch data from action class data memebers (This comes from Value Stack)  -->
<s:property value="language"/>::<s:property value="bestTutorialSite"/>
</body>
</html>