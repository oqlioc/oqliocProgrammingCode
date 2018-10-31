<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<%   request.setCharacterEncoding("EUC-KR");   %>
<title>쇼핑몰</title>
</head>
<script type="text/javascript">
	
</script>
<body>
<%
	 //이전창의 내용을 request를 받아서 사용
		if (session.isNew()) { // 세션이 생성될때
			out.println("<script> alert('로그인되었습니다')</script>");
			session.setAttribute("login", request.getParameter("userID")); // 세션의 login의 값인 홍길동을 넘겨준다
			
		}
		String IID= (String)session.getAttribute("login");
	%>


	<%= IID %><br>  <!-- login의 값을 리턴한다 --> 

	<form action="add.jsp">
		<table>
			<tr>
				<td>
					<select name="item">
						<option value="a">사과</option>
						<option value="b">배</option>
						<option value="c">오이</option>
						<option value="d">당근</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="추가">
					<input type="button" onclick="location.href='checkOut.jsp'" value="결제">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>