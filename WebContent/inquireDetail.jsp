<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<br><br><br><br><br><br><br><br>							
<%@ include file="include/header.jsp"%> 

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>


 <div class="container">
	<div class="row">
      <div class="col-xs-2 col-md-2"></div>
        <div class="col-xs-8 col-md-8">
         <h2 class="text-center">게시글 보기</h2><p>&nbsp;</p>
    <div class="table table-responsive">
        <table class="table">
        <tr>
            <th class="success">글번호</th>
            <td>${detailDto.inquireDto.inquire.id}</td>
            <th class="success">조회수</th>
            <td>${detailDto.inquireDto.inquire.readCount}</td>
        </tr>
           
         
        <tr>
            <th class="success">작성자</th>
            <td>${inquireDto.username}</td>
            <th class="success">작성일</th>
            <td>${detailDto.inquireDto.inquire.createDate}</td>
        </tr>
         
   
        <tr>
            <th class="success">제목</th>
            <td colspan="3">${detailDto.inquireDto.inquire.title}</td>
        </tr>
         
        <tr>
            <th class="success">글 내용</th>
            <td colspan="3">${detailDto.inquireDto.inquire.content}</td>
        </tr>
         
        <tr>
        
        <c:if test="${not empty sessionScope.principal}">
            <td colspan="4" class="text-center"> 
                                                                                          
            <a type="button" class="btn btn-warning"  href="/crossfit/inquire?cmd=update&id=${detailDto.inquireDto.inquire.id}">수정하기</a>          
            <a type="button" class="btn btn-danger"  href="/crossfit/inquire?cmd=delete&id=${detailDto.inquireDto.inquire.id}">삭제하기</a>          
  		    <a type="button" class="btn btn-primary"  href="/crossfit/inquire?cmd=inquireHome">목록보기</a>          
            </td>
           
                   
         </c:if>   
        </tr>    
      </table>
         <label for="content">comment</label>
        <form name="commentInsertForm">
            <div class="input-group">
               <input type="hidden" name="bno" value=""/>
                <textarea id="content__form" class="form-control" placeholder="write a comment..." rows="2"></textarea>
              <!-- <input type="text" class="form-control" id="content__form" name="content" placeholder="내용을 입력하세요."> --> 
               <span class="input-group-btn">
                    <button class="btn btn-success" type="button" name="commentInsertBtn" onclick="replyWrite(${detailDto.inquireDto.inquire.id},${sessionScope.principal.id})">댓글쓰기</button>
               </span>
              </div>
              
             <ul id="reply__list" class="media-list">
                 <c:forEach var="inquirereplyDto" items="${detailDto.inquirereplyDtos}">
              
                  <li id="reply-${inquirereplyDto.inquirereply.id}" class="media">
                   <img src="/crossfit/images/userProfile.png" alt="" class="img-circle">
                   <div class="media-body">
                       <strong class="text-primary">${inquirereplyDto.username}</strong>
                           <p>${inquirereplyDto.inquirereply.content}</p>
                   </div>	
                    <div class="m-2">
						<c:if test="${inquirereplyDto.inquirereply.userId eq sessionScope.principal.id}">
						   <i onclick="replyDelete(${inquirereplyDto.inquirereply.id})" style="font-size:20px;color:black; cursor:pointer" class="fas fa-trash" ></i>
						</c:if>
				   </div> 
                   
               </li>
               
              </c:forEach> 
          </ul>
        </form>
    </div>
     
  </div>
</div>
</div>
	
					

<br><br><br><br><br><br><br><br>
<script src="/crossfit/js/inquireReply.js"></script>
<%@ include file="include/footer.jsp"%>