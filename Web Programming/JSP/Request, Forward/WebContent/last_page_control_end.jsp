<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
%>
<body>
	<hr>
	<!-- 네번째 페이지 -->
	지금 보이는 화면은 last_spage_control_end.jsp에서 출력한 화면입니다.
	<hr>
	<!-- page_control_end.jsp에서 제어권을 받는다 
		두번쨰페이지 세번째페이지의 제어권을 받는다 -->
	이름 : <%=request.getParameter("username")%><br>
	전화번호 : <%=request.getParameter("tel")%>
	<br>
</body>
</html>