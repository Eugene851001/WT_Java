<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div align="center" style="background-color: #00FF00">
			Question constructor
		</div>
		<form action="controller?command=add_question" method="post">
			<div align="center">
				<input type="text" name="question_content" value=""/><br/>
				<input type="submit" name="submit" value="Add question" />
			</div>
		</form>
		<form action="controller?command=sign_out" method="post">
			<input type="submit" name="submit" value="Sign out">
		</form>
	</body>
</html>