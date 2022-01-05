<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>로그인</title>
</head>
<body>
<div class="body">
	<div class="container">
		<h1 class="text-center">회원가입</h1>
		<form action="<%=request.getContextPath()%>/signup" method="post">
		<div class="form-group">
			<input type="password" class="form-control" placeholder="아이디" name="me_id">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" placeholder="비밀번호" name="me_pw">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" placeholder="비밀번호확인" name="pw2">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="이름" name="me_name">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="생년월일" name="">
		</div>
		<div class="form-group">
		<!-- 성별 -->
		</div>
		<div class="form-group">
			<!-- 주소 -->
			</div>
			<button class="btn btn-outline-success col-12">로그인</button>
		</form>
	</div>
</div>
</body>
</html>