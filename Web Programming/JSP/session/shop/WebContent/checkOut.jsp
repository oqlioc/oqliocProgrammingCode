<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<%   request.setCharacterEncoding("EUC-KR");   %>
<title>Insert title here</title>
</head>
<body>
<%= session.getAttribute("userID") %> ���� ��ٱ��ϴ�?
<% ArrayList<String> arrr = (ArrayList) (session.getAttribute("productList")); %>
<hr>
        <% if (arrr == null) { %>
        ��ٱ��Ͽ� ���� ��ǰ�� �����ϴ�.
        <% } else {
                for (String i : arrr) {
                    out.println(i); %><br>
                <% }
        } %>



</body>
</html>