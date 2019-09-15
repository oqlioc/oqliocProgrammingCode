<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Login</h1>
	<hr>

	<form action="signin" method="post">
		<b> ID: </b><input type="text" name="id" /><br />
		<br /> <b> PASS: </b><input type="password" name="pw" /><br />
		<br /> <input type="submit" value="login" /><br />
		<br />
		<div>
			<label>
				<input type="checkbox" name="useCookie" />로그인 유지
			</label>
		</div>
	</form>

	<form action="signup_write">
		<input type="submit" value="join" />
	</form>
</body>
</html>
