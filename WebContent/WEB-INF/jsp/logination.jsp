<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
	</head>
	<body>
		<fmt:setLocale value="${sessionScope.locale}"/>
		<fmt:setBundle basename="resources.locale" var="loc" />
		<fmt:message bundle = "${loc}" key = "locale.password" var="password"/>
		<fmt:message bundle = "${loc}" key = "locale.log_in" var="logination"/>
		<fmt:message bundle = "${loc}" key = "locale.login" var="login"/>
		<fmt:message bundle = "${loc}" key = "locale.ready" var="ready"/>
		
		<div class='grid-container'>
			<div align="center" style="background: #00FF00">
				<c:out value="${logination}"/>
			</div>
			<div align="center">
				<form action="controller?command=log_in" method="post">
					<c:out value="${login}"/><br/>
					<input type="text" name="login" value="" /> <br/>
					<c:out value="${password}"/><br/>
					<input type="text" name="password" value=""/><br/>
					<input type="submit" name="submit" value="<c:out value="${ready}"/>" />
				</form>
				<c:out value="${sessionScope.loginError}"/>
			</div>
		</div>
	</body>
</html>