<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>include action</title>
</head>
<body>
<h2>include_action.jsp���� footer.jsp ȣ��</h2>
<hr>
include_action.jsp���� ����� �޽��� �Դϴ�.
<br>
<jsp:include page="footer.jsp">
	<jsp:param value="test@test.com" name="email"/>
	<jsp:param value="000-000-0000" name="tel"/>
</jsp:include>
</body>
</html>