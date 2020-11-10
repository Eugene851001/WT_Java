<%@ page language="java" import="by.testing.beans.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>

	</head>
	<body>
		<a href="controller?command=go_to_logination">log in</a>



		<div align="center">  
			<h2> 
				Hello, <c:out value="${sessionScope.user.name }"/> 
			</h2>
			<table>
				<tr>
					<td>Test name</td>
				</tr>
				<c:set var="list" value="${sessionScope.tests}"/>
				<c:forEach var="test" items="${list}">
					<tr><td><c:out value="${test.name}"/></td></tr>
				</c:forEach> 
			</table>
		</div>
		<form action="controller?command=sign_out" method="post">
			<input type="submit" name="submit" value="Sign out">
		</form>


	</body>
</html>
