<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>${board} List Page</h1>
	<!-- 검색 begin -->
	<form action="./selectList" id="frm">
		<input type="hidden" name="pn" value="1" id="pn">
		<select name="kind" id="kind">
			<option class="s" value="title">Title</option>
			<option class="s" value="contents">Contents</option>
			<option class="s" value="writer">Writer</option>
		</select>
		<input type="text" name="search" id="search">
<!-- 	<select name="perPage">
			<option value="5">5개씩 보기</option>
			<option value="10">10개씩 보기</option>
			<option value="20">20개씩 보기</option>
		</select>	 -->
		<button type="submit" id="btn">SEARCH</button>
	</form>
	<!-- 검색 end -->
	
	<table>
		<tr>
			<td>Num</td><td>Title</td><td>Writer</td><td>Date</td><td>Hit</td>
		</tr>
		<c:forEach items="${boardList}" var="boardVO">
			<tr>
				<td>${boardVO.num}</td>
				<td>
				<c:catch>
				<c:forEach begin="1" end="${boardVO.depth}">
					--
				</c:forEach>
				</c:catch>
				<a href="./selectOne?num=${boardVO.num}">${boardVO.title}</a></td>
				<td>${boardVO.writer }</td>
				<td>${boardVO.regDate }</td>
				<td>${boardVO.hit }</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${!pager.startCheck }">
		<button type="button" class="p" data-list-pn="${pager.startNum-1}">Pre</button>
	</c:if>
	<c:forEach begin="${pager.startNum}" end="${pager.lastNum }" var="i">
		<span class="p" data-list-pn="${i}">${i}</span>
	</c:forEach>
	<c:if test="${!pager.lastCheck}">
		<button class="p" data-list-pn="${pager.lastNum+1}">Next</button>
	</c:if>
	<br>	
	<c:if test="${board eq 'notice'}">
		<sec:authorize access="hasRole('ADMIN')">
			<a href="./insert">Write</a>
		</sec:authorize>
	</c:if>
	<c:if test="${board ne 'notice'}">
		<sec:authorize access="hasRole('MEMBER')">
			<a href="./insert">Write</a>
		</sec:authorize>
	</c:if>
	
	<script type="text/javascript" src="../js/list.js"></script>
	<script type="text/javascript">
		let kind = '${pager.kind}';
		let search = '${pager.search}';
		let pn = ${pager.pn};
		
		$(".s").each(function () {
			if($(this).val()==kind){
				$(this).prop("selected", true);
			}
		});
		$("#search").val(search);
		
		$(".p").click(function () {
			const n = $(this).attr("data-list-pn");
			$("#pn").val(n);
			$("#search").val(search);
			$("#kind").val(kind);
			$("#frm").submit();
		})
		
		
	</script>
</body>
</html>