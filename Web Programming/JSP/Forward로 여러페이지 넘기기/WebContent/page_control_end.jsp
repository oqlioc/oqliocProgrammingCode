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
	���� ���̴� ȭ���� page_control_end.jsp���� ����� ȭ���Դϴ�.
	<hr>
	�̸� : <%=request.getParameter("username")%><br>
	��ȭ��ȣ : <%=request.getParameter("tel")%><br>
	<hr>
	<jsp:forward page="last_page_control_end.jsp" />
</body>
</html>