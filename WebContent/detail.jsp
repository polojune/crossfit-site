<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>

 
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>


<br><br><br><br><br><br><br>
    	<div class="blog_post blog_post_light">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="blog_post_container">
							<div class="blog_post_image"><img src="${detailDto.board.wodImage}" alt=""></div>
							<div class="blog_post_content text-center">
								<div class="blog_post_title"><a href="#">"${detailDto.board.title}"</a></div>
								
							
								<div class="blog_post_text">
									<p>${detailDto.board.content}</p>
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
						<div class="panel-heading m-2"><b>댓글쓰기</b></div>
							<div class="panel-body">
								<textarea id="reply__write__form" class="form-control" placeholder="write a comment..." rows="3"></textarea>
								<br>
								
								<div class="clearfix">
								<button onclick="replyWrite(${detailDto.board.id},${sessionScope.principal.id})" class="btn btn-primary pull-right">댓글쓰기</button>
								</div>
								<hr />
								
								<!-- 댓글 리스트 시작-->
								<ul id="reply__list" class="media-list">
					
									<c:forEach var="replyDto" items="${detailDto.replyDtos}">
									<!-- 댓글 아이템 -->
									<li id="reply-${replyDto.reply.id}"   class="media">	
										<img src="/crossfit/images/userProfile.png" alt="" class="img-circle">		
										<div class="media-body">
											<strong class="text-primary">${replyDto.username}</strong>
											        <p>${replyDto.reply.content}</p>
																					
		   					            </div>
		   					         <div class="m-2">
									      <c:if test="${replyDto.reply.userId eq sessionScope.principal.id}">
									         <i onclick="replyDelete(${replyDto.reply.id})" style="font-size:20px;color:black; cursor:pointer" class="fas fa-trash" ></i>
									      </c:if>
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
			<a href="/crossfit/board?cmd=update&id=${boardDetail.id}"  class="btn btn-primary">수정</a> 
			<a href="/crossfit/board?cmd=delete&id=${boardDetail.id}"  class="btn btn-primary">삭제</a>
	 	</div>
 	 </div>  
   <br> 
    </c:if> 
<script src="/crossfit/js/reply.js"></script>	
<%@ include file="/include/footer.jsp"%>  