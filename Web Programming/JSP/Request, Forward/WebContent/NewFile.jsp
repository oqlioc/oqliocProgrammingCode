<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	request.setCharacterEncoding("utf-8");
%>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<table border=0>
		<tr>
			<td>
			<!-- index에서 넘어온 값을 request으로 받아옴 -->
				<%
					String user = request.getParameter("na");
					String job = request.getParameter("items1");
					String[] inter = request.getParameterValues("inter"); 
				%> 
				이름 :<%=user%><br> 직업 :<%=job%><br> 관심분야 :
				<%for (int i = 0; i < inter.length; i++) {%>
				<%=inter[i]%>
				<%}%>
			</td>
		</tr>
	</table>
<h2>request 테스트 결과 - 2</h2>
<table border=0>
   <tr>
      <td>
    1. 클라이언트 IP 주소 : <%= request.getRemoteAddr() %><br>
    2. 요청 메서드 : <%= request.getMethod() %><br>
	<%
		Cookie cookie[] = request.getCookies();
	%>
	3.
	<%for (int i = 0; i < cookie.length; i++) {%>
    <%= cookie[i].getName() %> 에 설정된 쿠키값 : <%= cookie[i].getValue() %><br>
    <%}%>
    4. 프로토콜 : <%= request.getProtocol() %>
      </td>
   </tr>
</table>
</body>
</html>