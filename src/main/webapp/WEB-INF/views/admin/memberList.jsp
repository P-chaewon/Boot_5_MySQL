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
	<h1>Member List Page</h1>
	<table>
		<tr>
			<td>ID</td><td>NAME</td><td>EMAIL</td><td>IMAGE</td>
		</tr>
		<c:forEach items="${memberList}" var="memberVO">
			<tr>
				<td>${memberVO.id }</td>
				<td>${memberVO.name }</td>
				<td>${memberVO.email }</td>
				<td><img alt="" src="../upload/member/${memberVO.memberFilesVO.fileName }" style="width: 200px;"> </td>		
			</tr>
		</c:forEach>
	</table>

</body>
</html>