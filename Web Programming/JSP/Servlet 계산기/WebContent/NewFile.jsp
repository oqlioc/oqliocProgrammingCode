<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>계산기</title>
</head>
<body>
	<h2 align="center">계산기</h2>
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
					<input type="submit" value="계산" name="b1">
					<input type="reset" value="다시입력" name="b2">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>