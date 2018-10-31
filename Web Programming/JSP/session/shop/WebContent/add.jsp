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
	 //이전창의 내용을 request를 받아서 사용
		 // 세션이 생성될때
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
			out.println("<script> alert('추가되었습니다'); location.href='setProduct.jsp';</script>");
			session.setAttribute("it", request.getParameter("item")); // 세션의 login의 값인 홍길동을 넘겨준다
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