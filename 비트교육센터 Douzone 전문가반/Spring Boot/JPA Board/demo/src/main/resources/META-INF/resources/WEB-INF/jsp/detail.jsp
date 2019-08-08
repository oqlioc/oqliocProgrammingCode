<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
	<input type="hidden" name="id" id="id" value="${board1.id}">
	<input type="text" name="name" id="name" value="${board1.name}">
	<input type="text" name="passwd" id="passwd" value="${board1.passwd}">
	<input type="text" name="title" id="title" value="${board1.title}">
	<input type="text" name="content" id="content" value="${board1.content}">
	<input type="submit">
	<!-- <input type="button" value="삭제" onclick="location.href='delete'"> -->
</form>
</body>
</html>