<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- �ι�° ������ -->
	<!-- ForwardSandRedirect.jsp���� �޾ƿ� ����  page_control_end.jsp���� ������� �Ѱ��ְ� ���� �ѱ�-->
	<jsp:forward page="page_control_end.jsp">
		<jsp:param value="000-000-0000" name="tel" />
	</jsp:forward>
</body>
</html>