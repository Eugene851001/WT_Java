<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"
prefix="fmt"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
	</head>
	<body>
		
		<fmt:setLocale value="${sessionScope.locale}"/>
		<fmt:setBundle basename="resources.locale" var="loc" />
		<fmt:message bundle = "${loc}" key = "locale.registration" var="registration"/>
		<fmt:message bundle = "${loc}" key = "locale.student" var="student"/>
		<fmt:message bundle = "${loc}" key = "locale.tutor" var="tutor"/>
		<fmt:message bundle = "${loc}" key = "locale.login" var="login"/>
		<fmt:message bundle = "${loc}" key = "locale.password" var="password"/>
		<fmt:message bundle = "${loc}" key = "locale.first_name" var="first_name"/>
		<fmt:message bundle = "${loc}" key = "locale.second_name" var="second_name"/>
		<fmt:message bundle = "${loc}" key = "locale.ready" var="ready"/>
		
		<div align="center" style="background-color: #00FF00">
			<c:out value="${registration}"/>
		</div>
		<form action="controller?command=registration" method="post">
			<div align="center">
				<c:out value="${first_name}"/><br/>
				<input type="text" name="user_first_name" value=""/><br/>
				<c:out value="${second_name}"/><br/>
				<input type="text" name="user_second_name" value=""/><br/>
				<c:out value="${login}"/><br/>
				<input type="text" name="login" value="" /> <br/>
				<c:out value="${password}"/><br/>
				<input type="text" name="password" value=""/><br/>
				<p><input name="user_type" type="radio" value="student"><c:out value="${student}"/></p>
				<p><input name="user_type" type="radio" value="tutor"><c:out value="${tutor}"/></p>
				<input type="submit" name="submit" value="<c:out value="${ready}"/>" />
			</div>
			<c:out value="${sessionScope.loginError}"/>
		</form>
	</body>
</html>