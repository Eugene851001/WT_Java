<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:setLocale value="${sessionScope.locale}"/>
	<fmt:setBundle basename="resources.locale" var="loc" />
	<fmt:message bundle = "${loc}" key = "locale.registration" var="registration"/>
	<fmt:message bundle = "${loc}" key = "locale.log_in" var="logination"/>
	
	<form action="controller?command=change_locale&page=index" method="post">
			<input type="hidden" name="local" value="ru">
			<input type="submit" name="submit" value="ru">
	</form>
	<form action="controller?command=change_locale&page=index" method="post">
		<input type="hidden" name="local" value="en">
		<input type="submit" name="submit" value="en">
	</form>
	
	<p>
		<a href="controller?command=go_to_registration">
			<c:out value="${registration}"/> 
		</a>
	</p>
	<p>
		<a href = "controller?command=go_to_logination">
			<c:out value="${logination}"/>
		</a>
	</p>
</body>
</html>