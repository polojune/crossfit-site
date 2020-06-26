<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
 <br><br><br><br><br><br><br>
    	<div class="blog_post blog_post_light">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="blog_post_container">
							<div class="blog_post_image"><img src="${boardDetail.wodImage}" alt=""></div>
							<div class="blog_post_content text-center">
								<div class="blog_post_title"><a href="#">"${boardDetail.title}"</a></div>
								
							
								<div class="blog_post_text">
									<p>${boardDetail.content}</p>
								</div>
						
							</div>
						</div>
					</div>
				</div>
			</div>			
		</div>
    <div class="row">
    <div class="col text-center">
	<a href="/crossfit/board?cmd=update&id=${boardDetail.id}"  class="btn btn-primary">수정</a> <a href="write.jsp"  class="btn btn-primary">삭제</a>
	 </div>
  </div>  
   <br> 
    
</body>
</html>
<%@ include file="/include/footer.jsp"%>  