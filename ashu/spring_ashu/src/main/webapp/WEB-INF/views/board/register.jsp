<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="body container">
	<h1>게시글 등록</h1>
	<form action="<%=request.getContextPath()%>/board/register" method="post" enctype="multipart/form-data">
	<div class="form-group">
	  <input type="text" class="form-control" name="bd_title" placeholder="제목">
	</div>
	<div class="form-group">
	  <textarea class="form-control" name="bd_contents" placeholder="내용" rows="10"></textarea>
	</div>
	<div class="form-group">
	  <label>첨부파일(최대 3개)</label>
	  <input type="file" class="form-control" name="files">
	  <input type="file" class="form-control" name="files">
	  <input type="file" class="form-control" name="files">
	</div>
	<button class="btn btn-outline-success col-12">등록</button>
	</form> 
  </div>
</body>
</html>

