<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 두번째 페이지 -->
	<!-- ForwardSandRedirect.jsp에서 받아온 값을  page_control_end.jsp으로 제어권을 넘겨주고 값을 넘김-->
	<jsp:forward page="page_control_end.jsp">
		<jsp:param value="000-000-0000" name="tel" />
	</jsp:forward>
</body>
</html>