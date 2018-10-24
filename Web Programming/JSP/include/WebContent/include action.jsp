<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>include action</title>
</head>
<body>
<h2>include_action.jsp에서 footer.jsp 호출</h2>
<hr>
include_action.jsp에서 출력한 메시지 입니다.
<br>
<jsp:include page="footer.jsp">
	<jsp:param value="test@test.com" name="email"/>
	<jsp:param value="000-000-0000" name="tel"/>
</jsp:include>
</body>
</html>