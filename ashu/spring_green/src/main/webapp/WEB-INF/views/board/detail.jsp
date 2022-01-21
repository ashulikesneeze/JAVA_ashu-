<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 상세 </h1>
	<div class="form-group">
	  <input type="text" class="form-control" name="bd_title" readonly value="${board.bd_title}">
	</div>
	<div class="form-group">
	  <input type="text" class="form-control" name="bd_me_id" readonly value="${board.bd_me_id}">
	</div>
	<div class="form-group">
	  <input type="text" class="form-control" name="bd_reg_date" readonly value="${board.bd_reg_date_str}">
	</div>
	<div class="form-group">
	  <textarea class="form-control" name="bd_contents" rows="10" readonly>${board.bd_contents}></textarea>
	</div>
	<div class="form-group">
		<label>첨부파일</label>
		<c:forEach items="${fileList}" var="file">
		<a class="form-control" href="<%=request.getContextPath()%>/board/download?fileName=${file.fi_name}">${file.fi_ori_name}</a>
		</c:forEach>
	</div>
	  <c:if test="${user != null && user.me_id == board.bd_me_id}">
	  <a href="<%=request.getContextPath()%>/board/modify?bd_num=${board.bd_num}">
		  	<button class="btn btn-outline-success">수정</button>
	  </a>
	  <a href="<%=request.getContextPath()%>/board/delete?bd_num=${board.bd_num}">
					<button class="btn btn-outline-success">삭제</button>
		</a>
	  </c:if>
	 <!-- ${fileList} --> 
</body>
</html>