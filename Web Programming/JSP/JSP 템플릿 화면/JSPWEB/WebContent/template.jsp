<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
        String ffile = request.getParameter("ffile");

        if (ffile == null) {  // 초기 화면
        	ffile = "newitem.jsp";
        }
%>
<form method="get">
	<table border="1" cellpadding="5" cellspacing="1" width="300" height="300">
		<tr>
			<td colspan="2"> <jsp:include page="top.jsp"/></td>
		</tr>
		<tr>
			<td width="30%"> <jsp:include page="left.jsp"/></td>
			<td width="70%"> <jsp:include page='<%= ffile %>'/></td>
		</tr>
		<tr>
			<td colspan="2"> <jsp:include page="bottom.jsp"/></td>
		</tr>
	</table>
</form>
</body>
</body>
</html>