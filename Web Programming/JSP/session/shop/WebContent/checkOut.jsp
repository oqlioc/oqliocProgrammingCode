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
<%= session.getAttribute("userID") %> 님의 장바구니는?
<% ArrayList<String> arrr = (ArrayList) (session.getAttribute("productList")); %>
<hr>
        <% if (arrr == null) { %>
        장바구니에 넣은 상품이 없습니다.
        <% } else {
                for (String i : arrr) {
                    out.println(i); %><br>
                <% }
        } %>



</body>
</html>