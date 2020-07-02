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
				         <c:forEach var="post" items="${posts}">
							<tr>
								<td>${post.inquire.id}</td>
								<td><a href="/crossfit/inquire?cmd=detail&id=${post.inquire.id}">${post.inquire.title}</a></td>
								<td>${post.username}</td>
								<td>${post.inquire.createDate}</td>
							</tr>
						   </c:forEach>	
					    </tbody>
						
					</table>
				</form>
			</section>
		    <hr/>
		 <c:if test="${not empty sessionScope.principal}">   
			<a href="/crossfit/inquire?cmd=saveForm" class="btn btn-primary" style="float: right">글쓰기</a>		
		 </c:if>
		</div>							 
													
					

<br><br><br><br><br><br><br><br>
 <%@ include file="include/inquirePaging.jsp"%>	
<%@ include file="include/footer.jsp"%>



