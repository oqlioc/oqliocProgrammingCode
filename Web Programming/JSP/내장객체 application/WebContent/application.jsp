<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>application.jsp</title>
</head>

<body>
<h2>application 예제</h2>
<hr>
1. 서버정보 : <%= application.getServerInfo() %><br> <!-- 웹 컨테이너의 이름과 버전을 리턴 -->
2. 서블릿 API 버전 정보 : <%= application.getMajorVersion()+"."+application.getMinorVersion() %>
3. application.jsp 파일의 실제 경로 : <%= application.getRealPath("application.jsp") %> <!-- 실제 시스템의 경로 -->

<hr>
setAttribute 로 username 변수에 "홍길동" 설정<p>
<%
   application.setAttribute("username", "홍길동");  // username의 이름으로 홍길동 값을 넘김
   application.log("username=홍길동");
   application.setAttribute("count", 1);  // count 이름으로 1 값을 넘김
%>

<a href="application_result.jsp">확인하기</a>

</body>
</html>