<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<html>
<head>
<meta charset="EUC-KR">
<title>import 속성 테스트</title>
</head>
<body>
<h1> 현재 시간 <%=new SimpleDateFormat().format(new Date())%>입니다.</h1>
</body>
</html>