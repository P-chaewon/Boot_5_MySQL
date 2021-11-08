<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Product Insert Page</h1>
	<form action="./productInsert" method="post" enctype="multipart/form-data">
		상품이름 : <input name="name" type="text"><br>
		상품가격 : <input type="number" name="price"><br>
		상품정보 : <input type="text" name="information"><br>
		상품 이미지 : <input type="file" name="files"><br>
		<button type="submit">상품등록</button>
	</form>

</body>
</html>