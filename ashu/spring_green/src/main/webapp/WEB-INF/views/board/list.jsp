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
  <h2>Contextual Classes</h2>
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
	        <th>${board.bd_num}</th>
	        <th><a href="#">${board.bd_title}</a></th>
	        <th>${board.bd_me_id}</th>
	         <th>${board.bd_reg_date_str}</th>
	      </tr>
     	 </c:forEach>
     	 </tbody>
	  </table>
	</div>
</body>
</html>
