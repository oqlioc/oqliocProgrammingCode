<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<hr>
지금 보이는 화면은 page_control_end.jsp에서 출력한 화면입니다.
<hr>
이름 : <%=request.getParameter("username") %> <br>
전화번호 : <%=request.getParameter("tel") %> <br>
</body>
</html>