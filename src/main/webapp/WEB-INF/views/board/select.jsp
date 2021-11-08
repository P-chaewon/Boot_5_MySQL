<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board } Select Page</h1>
	<p>${boardVO.title }</p>
	<p>${boardVO.writer }</p>
	<p>${boardVO.regDate }</p>
	<p>${boardVO.contents }</p>
	
	<c:forEach items="${boardVO.fileList}" var="fileVO">
		<a href="../upload/notice/${fileVO.fileName}">${fileVO.oriName}</a>
		<br>
	</c:forEach>
	
	
	<a href="./delete?num=${boardVO.num}">Delete</a>
	<a href="./update?num=${boardVO.num }">Update</a>
</body>
</html>