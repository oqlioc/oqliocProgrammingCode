<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<%   request.setCharacterEncoding("EUC-KR");   %>
<title>���θ�</title>
</head>
<body>
<%session.invalidate(); %>
<form action="setProduct.jsp" method="post">
	<table>
		<tr>
			<td>���̵�: <input type="text" name="userID"></td>
		</tr>
		<tr>
			<td>���: <input type="text" name="userPWD"></td>
		</tr>
		<tr>
			<td><input type="submit" value="�α���"></td>
		</tr>
	</table>
</form>
</body>
</html>