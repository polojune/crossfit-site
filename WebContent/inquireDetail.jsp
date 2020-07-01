<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<br><br><br><br><br><br><br><br>							
<%@ include file="include/header.jsp"%> 

 <div class="container">
	<div class="row">
      <div class="col-xs-2 col-md-2"></div>
        <div class="col-xs-8 col-md-8">
         <h2 class="text-center">게시글 보기</h2><p>&nbsp;</p>
    <div class="table table-responsive">
        <table class="table">
        <tr>
            <th class="success">글번호</th>
            <td>${inquireDetail.inquire.id}</td>
            <th class="success">조회수</th>
            <td>${inquireDetail.inquire.readCount}</td>
        </tr>
           
         
        <tr>
            <th class="success">작성자</th>
            <td>${inquireDetail.username}</td>
            <th class="success">작성일</th>
            <td>${inquireDetail.inquire.createDate}</td>
        </tr>
         
   
        <tr>
            <th class="success">제목</th>
            <td colspan="3">${inquireDetail.inquire.title}</td>
        </tr>
         
        <tr>
            <th class="success">글 내용</th>
            <td colspan="3">${inquireDetail.inquire.content}</td>
        </tr>
         
        <tr>
        <c:if test="${not empty sessionScope.principal}">
            <td colspan="4" class="text-center">
       <a type="button" class="btn btn-success"  href="">댓글쓰기</a>                                                                                           
            <a type="button" class="btn btn-warning"  href="/crossfit/inquire?cmd=update&id=${inquireDetail.inquire.id}">수정하기</a>          
            <a type="button" class="btn btn-danger"  href="/crossfit/inquire?cmd=delete&id=${inquireDetail.inquire.id}">삭제하기</a>          
  		    <a type="button" class="btn btn-primary"  href="">목록보기</a>          
            </td>
         </c:if>   
        </tr>    
      </table>
    </div>
     
  </div>
</div>
</div>
	
					

<br><br><br><br><br><br><br><br>
<%@ include file="include/footer.jsp"%>