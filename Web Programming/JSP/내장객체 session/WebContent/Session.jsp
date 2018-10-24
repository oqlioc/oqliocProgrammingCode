<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>session.jsp</title>
</head>

<body>
	<h2>session 예제</h2>
	<hr>
	<%
	 //이전창의 내용을 request를 받아서 사용
		if (session.isNew()) { // 세션이 생성될때
			out.println("<script> alert('세션이 해제되어 다시설정합니다.')</script>");
			session.setAttribute("login", "홍길동"); // 세션의 login의 값인 홍길동을 넘겨준다
		}
	%>

	#<%=session.getAttribute("login")%><br>  <!-- login의 값을 리턴한다 --> 
1. 세션 ID : <%=session.getId()%><br> <!-- 세션에 할당된 고유 식별자를 String 타입으로 리턴-->
2. 세션 유지시간 :<%=session.getMaxInactiveInterval()%><br> <!-- 세션 유지시간을 초 단위로 설정-->

</body>
</html>