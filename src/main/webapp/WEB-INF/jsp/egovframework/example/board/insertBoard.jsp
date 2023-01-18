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
<title>게시글 작성</title>
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
	.pwd {
		width : 100px;
	}
	h1 {
		text-align : center;
		margin-bottom : 80px;
	}
	
	.boardForm {
		width : 49%;
	}
</style>
</head>
<body>
	<h1>게시글 작성</h1>
	<div class="boardForm">
		<form action="${contextPath}/addBoard.do" method="post">
			<div style="margin-bottom : 20px;">작성자 : <input class="id" name="userId" type="text" placeholder="작성자명"></div>
			<div style="margin-bottom : 20px;">제목 : <input class="title" name="boardTitle" type="text" placeholder="제목을 입력해주세요."></div>
			<div style="margin-bottom : 20px; display : flex;">내용 : &nbsp<textarea class="content" name="boardContent" placeholder="내용을 작성해주세요."></textarea></div>
			<div style="margin-bottom : 20px;">비밀번호 : <input class="pwd" name="boardPwd" type="password"></div>
			<div style="float: right;"><input type="submit" value="등록하기"><input type="reset" value="초기화"></div>
		</form>
	</div>
</body>
</html>