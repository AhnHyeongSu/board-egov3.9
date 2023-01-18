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
<title>게시글 보기</title>
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
	
</style>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<div>
		<h1>글 상세보기</h1>
		<div class="boardForm">
			<form id="mod" action="${contextPath}/updateBoardView.do" method="post">
				<div class="inputs">별명 : <input class="id" name="userId" type="text" value="${boardView.userId}" readonly /></div>
				<div class="inputs">제목 : <input class="title" name="boardTitle" type="text" value="${boardView.boardTitle}" readonly /></div>
				<div class="inputs" style="display : flex;">내용 : &nbsp<textarea class="content" name="boardContent" value="${boardView.boardContent}" readonly>${boardView.boardContent}</textarea></div>
				<div>등록일 : <input class="date" type="text" value="${boardView.boardDate}" readonly /></div>
				<input type="hidden" id="boardNum" name="boardNum" value="${boardView.boardNum}">
				수정삭제를 하시려면 게시글의 비밀번호를 입력하고 버튼을 클릭해주세요 : <input type="password" id="checkPwd" name="checkPwd" autoComplete="off">
				<button type="button" id="modbtn">수정하기</button>
				<button type="button" id="delbtn">삭제하기</button>
			</form>
		</div>
	</div>
	<script>
	/* 수정하기  */
	var modBtn = document.getElementById('modbtn');
	var delBtn = document.getElementById('delbtn');
	
	modBtn.addEventListener('click', (e) => {
		
		var checkPwd = document.querySelector('#checkPwd').value;
		const num = document.getElementById('boardNum').value;
		
		$.ajax({
			url: "${contextPath}/pwdCheck.do",
			type: "post",
			data : {"num" : num, "checkPwd" : checkPwd},
			async: false,
			success: function(result) {
				if(result=="1") { // !!! js에서 === 는 형까지 체크 == 는 값 체크 구지 === 안써도 괜찮다
					alert("인증완료");
					$('#mod').submit();
					return;
				} else {
					console.log(result);
					alert("비밀번호가 틀립니다");
					location.reload();
					return;
				}
			},
			error: function() {
				alert("인증에 실패하였습니다.");
			}
		});
	
	});
	
	
	/* 삭제하기  */
	delBtn.addEventListener('click', (e) => {
		
	var checkPwd = document.querySelector('#checkPwd').value;
	const num = document.getElementById('boardNum').value;
	const pwd = document.getElementById('boardPwd').value;
		
	$.ajax({
		url: "${contextPath}/pwdCheck.do",
		type: "post",
		data : {"num" : num, "pwd" : pwd, "checkPwd" : checkPwd},
		async: false,
		success: function(result) {
			if(result=="1") {
				alert("인증완료");
				$("#mod").attr("action", "${contextPath}/deleteBoard.do");
				$('#mod').submit();
				return;
			} else {
				console.log(result);
				alert("비밀번호가 틀립니다");
				location.reload();
				return;
				}
			},
			error: function() {
				alert("인증에 실패하였습니다.");
			}
		});
	
	});
	
	
	</script>
</body>
</html>