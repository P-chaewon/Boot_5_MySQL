<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/test.css">
</head>
<body>
	<h1>Index Page</h1>
	
	<c:choose>
		<%-- 로그인 상태에서 보이는 화면 --%>
		<c:when test="${not empty member}">
			<h3>${member.id} 로그인 완료</h3>
			<a href="./member/memberLogout">LOGOUT</a>
			<br>
		</c:when>
		<%-- 로그아웃 상태에서 보이는 화면 --%>
		<c:otherwise>
			<a href="./member/memberLogin">LOGIN</a>
			<a href="./member/memberJoin">JOIN</a>
			<br>
		</c:otherwise>
	</c:choose>
	<img alt="wallpaper-2909130.jpg" src="./images/wallpaper-2909130.jpg" style="width: 300px;">
	<img alt="front" src="./front/wallpaper-2909123.jpg" style="width: 300px;">
</body>
</html>