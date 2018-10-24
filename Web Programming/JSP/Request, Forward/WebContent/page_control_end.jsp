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
	<!-- 세번째 페이지 -->
	지금 보이는 화면은 page_control_end.jsp에서 출력한 화면입니다.
	<hr>
	이름 : <%=request.getParameter("username")%><br>
	전화번호 : <%=request.getParameter("tel")%><br>
	<hr>
	<!-- forward_action2.jsp에서 제어권을 받는다 그리고  last_page_control_end.jsp으로 제어권을 넘겨주고 값을 넘김-->
	<jsp:forward page="last_page_control_end.jsp" />
</body>
</html>