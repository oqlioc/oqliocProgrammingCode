<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<%   request.setCharacterEncoding("EUC-KR");   %>
<title>���θ�</title>
</head>
<script type="text/javascript">
	
</script>
<body>
<%
	 //����â�� ������ request�� �޾Ƽ� ���
		if (session.isNew()) { // ������ �����ɶ�
			out.println("<script> alert('�α��εǾ����ϴ�')</script>");
			session.setAttribute("login", request.getParameter("userID")); // ������ login�� ���� ȫ�浿�� �Ѱ��ش�
			
		}
		String IID= (String)session.getAttribute("login");
	%>


	<%= IID %><br>  <!-- login�� ���� �����Ѵ� --> 

	<form action="add.jsp">
		<table>
			<tr>
				<td>
					<select name="item">
						<option value="a">���</option>
						<option value="b">��</option>
						<option value="c">����</option>
						<option value="d">���</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="�߰�">
					<input type="button" onclick="location.href='checkOut.jsp'" value="����">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>