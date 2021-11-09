<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootStrapCDN.jsp"></c:import>
</head>
<body>
	<h1>Join Page</h1>
	<div class="container mt-3 col-6">
		<form:form modelAttribute="memberVO" enctype="multipart/form-data">
			<div class="form-floating mb-3 mt-3">
				<form:input path="id" cssClass="form-control"/>
				<label for="id">ID</label>
				<form:errors path="id"></form:errors>
			</div>
			<div class="form-floating mb-3 mt-3">
				<form:password path="pw" cssClass="form-control"/>
				<label for="pw">PW</label>
				<form:errors path="pw"></form:errors>
			</div>
			<div class="form-floating mb-3 mt-3">
				<form:password path="pwCheck" cssClass="form-control"/>
				<label for="pwCheck">PW Check</label>
				<form:errors path="pwCheck"></form:errors>
			</div>
			<div class="form-floating mb-3 mt-3">
				<form:input path="name" cssClass="form-control"/>
				<label for="name">NAME</label>
				<form:errors path="name"></form:errors>
			</div>
			<div class="form-floating mb-3 mt-3">
				<form:input path="email" cssClass="form-control"/>
				<label for="email">EMAIL</label>
				<form:errors path="email"></form:errors>
			</div>
			<div class="form-floating mb-3 mt-3">
				<form:input path="age" cssClass="form-control"/>
				<label for="age">AGE</label>
				<form:errors path="age"></form:errors>
			</div>
			<div class="form-floating mb-3 mt-3">
				<form:input path="birth" cssClass="form-control"/>
				<label for="birth">BIRTH</label>
				<form:errors path="birth"></form:errors>
			</div>
			<div>
				<button type="submit">JOIN</button>
			</div>
		</form:form>
	</div>
</body>
</html>