<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>include ���þ� �׽�Ʈ</title>
</head>
<body>
	<center>
		<h2>include ���þ� �׽�Ʈ</h2>
		<hr>
		<%@ include file="NewFile.jsp"%>
		<p>
		<table border="0" cellpadding="5" cellspacing="1">
			<tr>
				<td><font size="-1"><%@include file="NewFile.jsp" %></font></td>
				<td width="30">&nbsp;</td>
				<td><font size="-1"><%@include file="nowTime.jsp" %></font></td>
			</tr>
		</table>
	</center>
</body>
</html>