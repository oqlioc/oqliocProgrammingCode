<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<body>
	<hr>
	���� ���̴� ȭ���� last_spage_control_end.jsp���� ����� ȭ���Դϴ�.
	<hr>
	�̸� : <%=request.getParameter("username")%><br>
	��ȭ��ȣ : <%=request.getParameter("tel")%>
	<br>
</body>
</html>