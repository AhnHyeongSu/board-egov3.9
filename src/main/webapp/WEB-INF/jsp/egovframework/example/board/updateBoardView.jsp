<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		margin : 0;
		padding : 0;
	}
	.id {
		width: 100px;
	}
	.title {
		width : 600px;
	}
	.content {
		width : 600px;
		height : 300px;
	}
	.date {
		width : 200px;
	}
	h1 {
		text-align : center;
		margin-bottom : 80px;
	}
	
	.boardForm {
		margin : auto;
		width : 49%;
	}
	
	.inputs {
		margin-bottom : 20px;  
	}
	
	.boardbody {
		margin : auto;
	}
</style>
</head>
<body>
	<div>
		<h1>글 상세보기</h1>
		<div class="boardForm">
			<form action="${contextPath}/updateBoard.do" method="post">
				<div class="inputs">별명 : <input class="id" name="userId" type="text" value="${oldText.userId}" readonly/></div>
				<div class="inputs">제목 : <input class="title" name="boardTitle" type="text" value="${oldText.boardTitle}" /></div>
				<div class="inputs" style="display : flex;">내용 : &nbsp<textarea class="content" name="boardContent" value="${oldText.boardContent}">${oldText.boardContent}</textarea></div>
				<input type="hidden" name="boardNum" value="${oldText.boardNum}">
				<input type="submit" value="등록하기">
			</form>
		</div>
	</div>
</body>
</html>