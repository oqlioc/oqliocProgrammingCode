<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<%   request.setCharacterEncoding("EUC-KR");   %>
<title>Insert title here</title>
<%
	 //����â�� ������ request�� �޾Ƽ� ���
		 // ������ �����ɶ�
	String item = request.getParameter("item");
	ArrayList<String> itemlist = new ArrayList<String>();
		
	if(session.getAttribute("productlist")==null){
		itemlist.add(item);
	}else{
		itemlist = (ArrayList)session.getAttribute("productlist");
		itemlist.add(item);
	}
	session.setAttribute("productlist", itemlist);
		 /* 
		if( session.getAttribute("login") != null) {
			out.println("<script> alert('�߰��Ǿ����ϴ�'); location.href='setProduct.jsp';</script>");
			session.setAttribute("it", request.getParameter("item")); // ������ login�� ���� ȫ�浿�� �Ѱ��ش�
			String IIT= (String)session.getAttribute("it");
			

			if(session.getAttribute("it") != null) {
				
				ArrayList<String> asdf = new ArrayList<>();
				asdf.add(IIT);
				session.setAttribute("AALIST", asdf);
				
			}
			
		}else {
			
			
		}
		*/
 %>
 <script type="text/javascript">
 	function add() {
		var item = "<%=item%>";
		alert(item);
		history.go(-1);
	}
 </script>
</head>
<body onload="add()">

</body>
</html>