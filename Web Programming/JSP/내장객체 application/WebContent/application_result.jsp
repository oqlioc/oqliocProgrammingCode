<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<% int cnt= (int)application.getAttribute("count");  // count�� ���� int������ �޾ƿ� %>  
<%= cnt %>
<% application.setAttribute("count", ++cnt);  // count�� ���� int������ �޾ƿ�%>

</body>
</html>