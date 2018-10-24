<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<% int cnt= (int)application.getAttribute("count");  // count의 값을 int형으로 받아옴 %>  
<%= cnt %>
<% application.setAttribute("count", ++cnt);  // count의 값을 int형으로 받아옴%>

</body>
</html>