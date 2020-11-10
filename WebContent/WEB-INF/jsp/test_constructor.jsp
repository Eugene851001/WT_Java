<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div align="center" style="background-color: #00FF00">
			Test constructor
		</div>
		<div align="center">
			Questions:
			<table>
				<c:set var="list" value="${sessionScope.questions}"/>
				<c:forEach var="question" items="${list}">
						<tr>
							<td><c:out value="${question.content}"/></td>
						</tr>
				</c:forEach>
			</table> 
			<p><a href="controller?command=go_to_question_constructor">Add question</a></p>
		</div>
		<form action="controller?command=add_test" method="post">
			<div align="center">
				Test name<input type="text" name="test_name" value="${sessionScope.test.name}"/><br/>
				<input type="submit" name="submit" value="Create test" />
			</div>
		</form>
		<form action="controller?command=sign_out" method="post">
			<input type="submit" name="submit" value="Sign out">
		</form>
	</body>
</html>