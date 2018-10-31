<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<%   request.setCharacterEncoding("EUC-KR");   %>
<title>쇼핑몰</title>
</head>
<body>
<%session.invalidate(); %>
<form action="setProduct.jsp" method="post">
	<table>
		<tr>
			<td>아이디: <input type="text" name="userID"></td>
		</tr>
		<tr>
			<td>비번: <input type="text" name="userPWD"></td>
		</tr>
		<tr>
			<td><input type="submit" value="로그인"></td>
		</tr>
	</table>
</form>
</body>
</html>