<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="beantest" class="Test.BeanTest" scope="page"/>   
<%--자바빈 객체의 멤버변수를 직접 수정하는 것이 아니라 setter 호출. --%>
<jsp:setProperty name="beantest" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
   request.setCharacterEncoding("UTF-8"); 
%>
<title>JavaBean Test</title>
</head>

<body>
<b>자바빈 사용 예제</b><br/>
아이디<jsp:getProperty name="beantest" property="uid" /><br/>

비번<jsp:getProperty name="beantest" property="upw" /><br/>
비번 확인<jsp:getProperty name="beantest" property="checkupw" /><br/>
이메일<jsp:getProperty name="beantest" property="uemail" /><br/>
이름<jsp:getProperty name="beantest" property="uname" /><br/>
주민번호<jsp:getProperty name="beantest" property="unum1" /><br/>
<jsp:getProperty name="beantest" property="unum2" /><br/>
자기소개<jsp:getProperty name="beantest" property="self" /><br/>
취미<jsp:getProperty name="beantest" property="inter" /><br/>


<%-- <h3><jsp:getProperty name="beantest" property="*" /></h3> --%>
<%--
자바 빈 객체의 멤버 변수를 접근 하는 것이 아니라 getter 호출
<h3><jsp:getProperty name="beantest" property="name"/></h3>
 --%>
</body>
</html>