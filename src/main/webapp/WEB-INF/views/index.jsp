<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/test.css">
</head>
<body>
	<h1>Index Page <spring:message code="hello.hi"></spring:message></h1>
	
	<spring:message code="hello" var="m" text="Default Message"></spring:message>
	<c:choose>
		<%-- 로그인 상태에서 보이는 화면 --%>
		<c:when test="${not empty member}">
			<h3>${member.id}</h3>
			<h3><spring:message code="member.info" arguments="${member.id},${member.email}" argumentSeparator=","></spring:message></h3>
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
	<h1>${m}</h1>
	<img alt="wallpaper-2909130.jpg" src="./images/wallpaper-2909130.jpg" style="width: 300px;">
	<img alt="front" src="./front/wallpaper-2909123.jpg" style="width: 300px;">
</body>
</html>