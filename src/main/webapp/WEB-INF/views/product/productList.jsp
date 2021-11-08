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
	<h1>Product List Page</h1>
	<table>
		<tr>
			<td>상품 이름</td><td>상품 가격</td><td>상품 정보</td><td>상품 이미지</td>
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.name }</td>
				<td>${product.price }</td>
				<td>${product.information }</td>
				<td><img alt="" src="../upload/product/${product.productFilesVO.fileName}" style="width: 200px"></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>