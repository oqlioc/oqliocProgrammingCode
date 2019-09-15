<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String userId = (String) session.getAttribute("userId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 성공 입니다.</h1>

	<h2>${userId}님환영합니다~</h2>
	<br />
	<br />

	<input type="submit" value="Logout" onclick="location.href='logout'" />

</body>
</html>