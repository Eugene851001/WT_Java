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
			Registration
		</div>
		<form action="controller?command=registration" method="post">
			<div align="center">
				<input type="text" name="user_first_name" value=""/><br/>
				<input type="text" name="user_second_name" value=""/><br/>
				<input type="text" name="login" value="" /> <br/>
				<input type="text" name="password" value=""/><br/>
				<p><input name="user_type" type="radio" value="student">Студент</p>
				<p><input name="user_type" type="radio" value="tutor">Тьютор</p>
				<input type="submit" name="submit" value="press me" />
			</div>
		</form>
	</body>
</html>