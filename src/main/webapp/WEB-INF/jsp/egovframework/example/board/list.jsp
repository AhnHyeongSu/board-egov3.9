<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="result" value="${result}" />
<%
  request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<style>
	body {
		text-align: center;
		width: 70%;
		margin : auto;
		padding : 0;
	}
	
	.boardList {
		text-align : center;
	}
	
	.ib {
		float : right;
	}
</style>
<script>
	console.log(${result});
</script>
</head>
<body>
	<h1 style="margin-bottom:50px;">게시판</h1>
	<div>
		<form class="ib" action="${contextPath}/insertBoard.do" method="post">
			<input type="submit" value="글 쓰기">
		</form>
	</div>
	<div class="boardList">
		<table class="table table-striped">
			<tr>
				<th scpoe="col">게시글번호</th>
				<th scpoe="col">작성자</th>
				<th scpoe="col">제목</th>
				<th scpoe="col">최종수정일</th>
			</tr>
			<c:forEach items="${boardlist}" var="result">
				<tr>
					<td>${result.boardNum}</td>
					<td>${result.userId}</td>
					<td><a href='<c:url value="/boardView.do?boardNum=${result.boardNum}"/>'>${result.boardTitle}</a></td>
					<td>${result.boardDate}</td>
				</tr>
			</c:forEach>
		</table>
		<ul class="paging">
			<c:if test="${paging.prev}">
				<span><a href='<c:url value="/list.do?page=${paging.startPage-1}"/>'>이전</a></span>
			</c:if>
			<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num" varStatus="i">
				<span><a href='<c:url value="/list.do?page=${num}"/>' class="testClass" name="testName">${num}</a></span>
			</c:forEach>
			<c:if test="${paging.next && paging.endPage>0}">
				<span><a href='<c:url value="/list.do?page=${paging.endPage+1}"/>'>다음</a></span>
		</c:if>
		</ul>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
	<script>
		document.addEventListener("DOMContentLoaded", function(){
			var pageList = $('.testclass').querySelectorAll;
			var pageNum = ${pageNum}; 
			console.log(pageNum);
			console.log(pageList);
			for(i=0; i<pageList.lenght; i++) {
				if(pageList[i].innerHTML == pageNum) {
					var tmp =  $('.testClass')[i];
					$(tmp).css("color", "red");
				}
			}
		});
	</script>
</body>
</html>