<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	${label}  <--This is EL-->
	<br>

	<br>
	Now using JSTL
	<c:out value="${label}"></c:out>	
	<br>
	<br>
	<br>
	Now printing student data
	<!-- if we are using userdefined classes they have to be pojos or beans  -->
	<h1>${student.name}</h1>
	<br>
	<h2>${student}</h2>
	
	${students[1]} 
	
	<br>
	<br>
	Using forEach
	<br>
	<br>
	<c:forEach items="${students}" var ="s">
	${s} <br>
	</c:forEach>
	
	
	<br>
	<br>
	Using JSTL sql tags
	
	<sql:setDataSource var="db" driver = "org.postgresql.Driver" url = "jdbc:postgresql://localhost:5532/postgres" 
	user = "postgres" password = "1234" />
	
	<sql:query var="rs" dataSource = "${db}">select * from sessions where session_id <= 10 </sql:query>
	<br>
	<h1>Printing Session Names </h1>
	<br> 
	<c:forEach items="${rs.rows}" var="session">
		<c:out value="${session.session_name}"></c:out> <br>
	</c:forEach>
	
	<br>
	<br>
	<h2>Now using JSTL FUnction Tags</h2>
	
	<br>
	<br>
	<c:set var = "str" value="Vamsi is an amazing coder"></c:set>
	
	Length of str = ${fn:length(str)} 
	
	<c:forEach items="${fn:split(str,' ')}" var="s">
	<br>
	${s} 
	</c:forEach>
	<br>
	<br>
	Does the string cointain coder ?
	<c:if test="${fn:contains(str,'coder') }">
		Yes from if block
	</c:if>
	
</body>
</html>