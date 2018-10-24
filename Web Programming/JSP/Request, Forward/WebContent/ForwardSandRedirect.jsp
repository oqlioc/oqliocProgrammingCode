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
	<form action="forward_action2.jsp" method="post">
		forward action : <input type="text" name="username">
		<input type="submit" value="확인">
	</form>

	<form action="response_sandRedirect.jsp" method="post">
		response.sandRedirect : <input type="text" name="username">
		<input type="submit" value="확인">
	</form>
</body>
</html>