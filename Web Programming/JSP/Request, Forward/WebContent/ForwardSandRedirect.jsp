<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Forward SandRedirect 테스트</title>
</head>
<body>
	<h2>Forward, SandRedirect 테스트</h2>
	<hr>
	<!-- 첫번째 페이지 -->
	<!-- forward_action2.jsp으로 username의  값으로 넘긴다 -->
	<form action="forward_action2.jsp" method="post">
		forward action : <input type="text" name="username">
		<input type="submit" value="확인">
	</form>
	
	<!-- response_sandRedirect.jsp으로 username의  값으로 넘긴다 -->
	<form action="response_sandRedirect.jsp" method="post">
		response.sandRedirect : <input type="text" name="username">
		<input type="submit" value="확인">
	</form>
</body>
</html>