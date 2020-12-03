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
		<fmt:message bundle = "${loc}" key = "locale.tutor.greetings" var="greetings"/>
		<fmt:message bundle = "${loc}" key = "locale.tutor.edit" var="edit"/>
		<fmt:message bundle = "${loc}" key = "locale.sign_out" var="exit"/>
		<fmt:message bundle = "${loc}" key = "locale.tutor.delete" var="delete"/>
		
		<form action="controller?command=change_locale&page=main_tutor" method="post">
			<input type="hidden" name="local" value="ru">
			<input type="submit" name="submit" value="ru">
		</form>
		<form action="controller?command=change_locale&page=main_tutor" method="post">
			<input type="hidden" name="local" value="en">
			<input type="submit" name="submit" value="en">
		</form>

		<div align = "center">  
			<h2> 
				<c:out value="${greetings}"/>, <c:out value="${sessionScope.user.name }"/> 
			</h2>
			<table>
				<tr>
					<td>Test name</td>
				</tr>
				<c:set var="list" value="${sessionScope.tests}"/>
				<c:forEach var="test" items="${list}">
					<tr>
						<td><c:out value="${test.name}"/></td>
						<td><a href="controller?command=edit_test&test_id=<c:out value="${test.id}"/>"><c:out value="${edit}"/></a></td>
						<td><a href="controller?command=delete_test&test_id=<c:out value="${test.id}"/>"><c:out value="${delete}"/></a></td>
					</tr>
				</c:forEach> 
			</table>
			<p><a href="controller?command=go_to_testconstructor">Add test</a></p>
		</div>
		<form action="controller?command=sign_out" method="post">
			<input type="submit" name="submit" value="<c:out value="${exit}"/>">
		</form>

	</body>
</html>