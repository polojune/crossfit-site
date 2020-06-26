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
	<!-- 댓글 박스 -->
	<div class="container">
		<hr />
		<div class="row bootstrap snippets">
		<div class="col-md-12">
			<div class="comment-wrapper">
				<div class="panel panel-info">
					<div class="panel-heading m-2"><b>Comment</b></div>
					<div class="panel-body">
						<textarea class="form-control" placeholder="write a comment..." rows="3"></textarea>
						<br>
						<button onclick="replyWrite" class="btn btn-primary pull-right">댓글쓰기</button>
						<div class="clearfix"></div>
						<hr />
						<!-- 댓글 리스트 시작-->
						<ul class="media-list">
						
							<c:forEach begin="1" end="10">
							<!-- 댓글 아이템 -->
							<li class="media">	
								<img src="https://bootdey.com/img/Content/user_1.jpg" alt="" class="img-circle">		
								<div class="media-body">
									<strong class="text-primary">@MartinoMont</strong>
									<p>
										
									</p>
								</div>
							</li>
							</c:forEach>
						</ul>
						<!-- 댓글 리스트 끝-->
					</div>
				</div>
			</div>

		</div>
	</div>
	</div>
	
	<!-- 댓글 박스 끝 -->
		
   <c:if test="${not empty sessionScope.admin}">
    <div class="row">
    <div class="col text-center">
	
	<a href="/crossfit/board?cmd=update&id=${boardDetail.id}"  class="btn btn-primary">수정</a> <a href="/crossfit/board?cmd=delete&id=${boardDetail.id}"  class="btn btn-primary">삭제</a>
	 </div>
  </div>  
   <br> 
     </c:if> 
</body>
</html>
<%@ include file="/include/footer.jsp"%>  