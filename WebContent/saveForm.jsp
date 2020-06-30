<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ include file="include/header.jsp"%> 
<br><br><br><br><br><br><br><br>	    
        <div class="container">
	<form action="" method="POST" enctype="multipart/form-data">
  
         <h1>게시판</h1>
	<div class="form-group">
		<label for="comment">Title:</label> <input type="text" class="form-control" placeholder="title" id="title" name="title" required>
	</div>
    
 	<div class="form-group">
		 <label for="content">Content:</label>
		 <textarea id="summernote" class="form-control" rows="5" id="content" name="content" required></textarea>
	</div>
     	
     	<button type="submit" class="btn btn-primary">글쓰기 등록</button>
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
<br><br><br><br><br><br><br><br>
<%@ include file="include/footer.jsp"%>			