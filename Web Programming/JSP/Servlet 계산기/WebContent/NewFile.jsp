<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����</title>
</head>
<body>
	<h2 align="center">����</h2>
	<hr>
	<form name="form1" action="test" method="post">
		<table align="center">
			<tr>
				<td>
					<input type="text" name="num1">
					<select name="oper">
						<option value="+">+</option>
						<option value="-">-</option>
						<option value="*">*</option>
						<option value="/">/</option>
					</select>
					<input type="text" name="num2">
					<input type="submit" value="���" name="b1">
					<input type="reset" value="�ٽ��Է�" name="b2">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>