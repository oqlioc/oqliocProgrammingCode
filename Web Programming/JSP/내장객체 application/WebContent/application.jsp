<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>application.jsp</title>
</head>

<body>
<h2>application ����</h2>
<hr>
1. �������� : <%= application.getServerInfo() %><br> <!-- �� �����̳��� �̸��� ������ ���� -->
2. ���� API ���� ���� : <%= application.getMajorVersion()+"."+application.getMinorVersion() %>
3. application.jsp ������ ���� ��� : <%= application.getRealPath("application.jsp") %> <!-- ���� �ý����� ��� -->

<hr>
setAttribute �� username ������ "ȫ�浿" ����<p>
<%
   application.setAttribute("username", "ȫ�浿");  // username�� �̸����� ȫ�浿 ���� �ѱ�
   application.log("username=ȫ�浿");
   application.setAttribute("count", 1);  // count �̸����� 1 ���� �ѱ�
%>

<a href="application_result.jsp">Ȯ���ϱ�</a>

</body>
</html>