<%@ page language="java" import="by.testing.beans.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Test result</title>

	</head>
	<body>
		<fmt:setLocale value="${sessionScope.locale}"/>
		<fmt:setBundle basename="resources.locale" var="loc" />
		<fmt:message bundle = "${loc}" key = "locale.student.result" var="result"/>
		
		<form action="controller?command=change_locale" method="post">
			<input type="hidden" name="local" value="ru">
			<input type="submit" name="submit" value="ru">
		</form>
		<form action="controller?command=change_locale" method="post">
			<input type="hidden" name="local" value="en">
			<input type="submit" name="submit" value="en">
		</form>


		<div align="center">  
			<h2> 
				<c:out value="${result}"/>:
				<c:out value="${sessionScope.result}"/>
			</h2>
			<a href="controller?command=go_to_student_main">Go to main page</a>
		</div>


	</body>
</html>