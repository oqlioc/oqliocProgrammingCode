<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>request 테스트 폼</title>
</head>
<script type="text/javascript">
	document.cookie = "test=OK.";
</script>
<body>
	<h2>request 테스트 폼</h2>
	<hr>
	<form name="form1" action="NewFile.jsp" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="na" placeholder="superman"></td>
			</tr>
			<tr>
				<td>직업</td>
				<td>
					<select name="items1">
						<option value="HTML">HTML</option>
						<option value="자바스크립트">자바스크립트</option>
						<option value="CSS">CSS</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>관심분야</td>
				<td>
					<input type="checkbox" name="inter" value="컴퓨터"><label
					for="q">컴퓨터</label> <input type="checkbox" name="inter" value="인터넷"><label
					for="w">인터넷</label> <input type="checkbox" name="inter" value="여행"><label
					for="e">여행</label>
				</td>
			<tr>
				<td>
					<input type="submit" value="확인"><input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>