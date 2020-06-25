<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
    
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
    
    
</body>
</html>