<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<br><br><br><br><br><br><br><br>
<title>게시판</title>
	
		<div class="container">
			<header>
				<h1> 게시판</h1>
			</header>
		
			 <%@ include file="include/header.jsp"%> 
	 
			<section id="container">
				<form role="form" >
					<table class="table table-hover">
						<thead>
							<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>등록일</th>
							</tr>
						</thead>
					
				        <tbody>
				         <c:forEach var="post" items="${post}">
							<tr>
								<td>${post.id}</td>
								<td><a href="/crossgit/inquire?cmd=detail&id=${post.id}">${post.title}</a></td>
								<td>${post.userName}</td>
								<td>${post.createDate}</td>
							</tr>
						   </c:forEach>	
					    </tbody>
						
					</table>
				</form>
			</section>
		    <hr/>
			<a href="/crossfit/inquire?cmd=saveForm">글쓰기</a>			
		</div>			
		
			 

				
									
					

<br><br><br><br><br><br><br><br>
   <%@ include file="include/paging.jsp"%>	
	<%@ include file="include/footer.jsp"%>



