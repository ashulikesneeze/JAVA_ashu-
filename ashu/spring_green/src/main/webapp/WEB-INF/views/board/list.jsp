<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<!-- ${list} -->
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
		<c:if test="${pm.criteria.type != null && pm.criteria.type == '일반' }">
			<h1>게시글</h1>
		</c:if>
		<c:if test="${pm.criteria.type != null && pm.criteria.type == '공지'}">
			<h1>공지사항</h1>
		</c:if>
		<form class="input-group mb-3" action="<%=request.getContextPath()%>/board/list">
		  <input type="text" class="form-control" name="search" placeholder="검색어를 입력하세요." value="${pm.criteria.search }">
		  <div class="input-group-append">
		    <button class="btn btn-success" type="submit">검색</button>
		  </div>
		  	<input type="hidden" name="type" value="${pm.criteria.type }">
		</form>
  <table class="table table-hover table-success">
    <thead class="thead-dark">
   	  <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
      </tr>  
    </thead>  
   		<tbody>
    	<c:forEach var="board" items="${list}"> 
	      <tr>
	        <td>${board.bd_num}</td>
	        <td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">${board.bd_title}</a></td>
	        <td>${board.bd_me_id}</td>
	         <td>${board.bd_reg_date_str}</td>
	      </tr>
     	 </c:forEach>
     	 </tbody>
	  </table>
		  <a href="<%=request.getContextPath()%>/board/register">
		  	<button class="btn btn-outline-success">등록</button>
		  </a>
	</div>
</body>
</html>
