<%@ page language="java" import="by.testing.beans.*" contentType="text/html; charset=utf-8"
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
		<fmt:message bundle = "${loc}" key = "locale.student.next" var="next"/>
		<fmt:message bundle = "${loc}" key = "locale.question" var="question"/>

		<div align="center">  
			<h2> 
				<c:out value="${sessionScope.test.name}"/> 
			</h2>
			<p><c:out value="${question}"/>: <c:out value="${sessionScope.question.content}"/></p>
			<a href="controller?command=go_to_next_question"><c:out value="${next}"/></a>
		</div>

	</body>
</html>