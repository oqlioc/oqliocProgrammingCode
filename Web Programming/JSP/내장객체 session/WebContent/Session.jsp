<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>session.jsp</title>
</head>

<body>
	<h2>session ����</h2>
	<hr>
	<%
	 //����â�� ������ request�� �޾Ƽ� ���
		if (session.isNew()) { // ������ �����ɶ�
			out.println("<script> alert('������ �����Ǿ� �ٽü����մϴ�.')</script>");
			session.setAttribute("login", "ȫ�浿"); // ������ login�� ���� ȫ�浿�� �Ѱ��ش�
		}
	%>

	#<%=session.getAttribute("login")%><br>  <!-- login�� ���� �����Ѵ� --> 
1. ���� ID : <%=session.getId()%><br> <!-- ���ǿ� �Ҵ�� ���� �ĺ��ڸ� String Ÿ������ ����-->
2. ���� �����ð� :<%=session.getMaxInactiveInterval()%><br> <!-- ���� �����ð��� �� ������ ����-->

</body>
</html>