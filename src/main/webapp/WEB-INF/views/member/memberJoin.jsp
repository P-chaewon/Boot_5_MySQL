<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join Page</h1>
	<form action="./memberJoin" method="post" enctype="multipart/form-data">
		id : <input type="text" name="id"><br>
		pw : <input type="password" name="pw"><br>
		name : <input type="text" name="name"><br>
		email : <input type="email" name="email"><br>
		image : <input type="file" name="files"><br>
		<button type="submit">JOIN</button>	
	</form>
</body>
</html>