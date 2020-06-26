<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>




  <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>


<div class="container">

<br><br><br><br><br><br>

<form action="/crossfit/board?cmd=updateProc" method="POST" >
     <input type="hidden" value="${board.id}" name="id"/>
          <h1>게시판</h1>
	<div class="form-group">
		<label for="comment">Title:</label> <input type="text" value="${board.title}" class="form-control" placeholder="title" id="title" name="title" required>
	</div>
  
   
	<div class="form-group">
		<label for="content">Content:</label>
		<textarea id="summernote" class="form-control" rows="5" id="content" name="content" required>${board.content}</textarea>
	</div>

	<button type="submit" class="btn btn-primary">수정 </button>
</form>
</div>

<script>
  $(document).ready(function() {
      $('#summernote').summernote({
    	  tabsize: 2,
          height: 300
      });
  });
</script>  
  