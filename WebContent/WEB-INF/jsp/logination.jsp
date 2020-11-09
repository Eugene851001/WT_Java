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
		<div class='grid-container'>
			<div align="center" style="background: #00FF00">
				Logination
			</div>
			<div align="center">
				<form action="controller?command=log_in" method="post">
					<input type="text" name="login" value="" /> <br/>
					<input type="text" name="password" value=""/><br/>
					<input type="submit" name="submit" value="press me" />
				</form>
			</div>
		</div>
	</body>
</html>