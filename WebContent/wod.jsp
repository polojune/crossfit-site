<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Crossfit template project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap-4.2.1/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/blog.css">
<link rel="stylesheet" type="text/css" href="styles/blog_responsive.css">


	<div class="home">
		<div class="parallax_background parallax-window" data-parallax="scroll" data-image-src="images/blog.jpg" data-speed="0.8"></div>
		<div class="home_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="home_content text-center">
							<div class="home_title">wod</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Blog -->
    

    
	<div class="blog">
	<c:forEach var="board" items="${boards}">
		<!-- Blog Post -->
		<div class="blog_post blog_post_light">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="blog_post_container">
							<div class="blog_post_image"><img src="${board.wodImage}" alt=""></div>
							<div class="blog_post_content text-center">
								<div class="blog_post_title"><a href="#">"${board.title}"</a></div>
								
							
								<div class="blog_post_text">
									<p>${board.content}</p>
								</div>
								<div class="button blog_post_button"><a href="/crossfit/board?cmd=detail&id=${board.id}">상세보기</a></div>
							</div>
						</div>
					</div>
				</div>
			</div>			
		</div>

	</c:forEach>


<%@ include file="include/wodPaging.jsp"%>	
 
    <c:if test="${not empty sessionScope.admin}">
  <div class="row">
    <div class="col text-center">
	<a href="write.jsp"  class="btn btn-primary">동영상 등록</a>
	 </div>
  </div>
  <br><br>
   </c:if>

	<%@ include file="include/footer.jsp"%>	