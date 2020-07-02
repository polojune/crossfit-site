<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <input type="button" class="btn btn-success"  value="답글 쓰기" onclick= ""/>
    <div class="container">
        <label for="content">comment</label>
        <form name="commentInsertForm">
            <div class="input-group">
               <input type="hidden" name="bno" value="${detail.bno}"/>
               <input type="text" class="form-control" id="content" name="content" placeholder="내용을 입력하세요.">
               <span class="input-group-btn">
                    <button class="btn btn-default" type="button" name="commentInsertBtn">등록</button>
               </span>
              </div>
        </form>
    </div>
    
    <div class="container">
        <div class="commentList"></div>
    </div>

     <a type="button" class="btn btn-success"  href="">댓글쓰기</a>  
    <ul id="reply__list" class="media-list">
       <li id="reply-${replyDto.reply.id}"   class="media">	
		<img src="/crossfit/images/userProfile.png" alt="" class="img-circle">		
			<div class="media-body">
				<strong class="text-primary">${replyDto.username}</strong>
				        <p>${replyDto.reply.content}</p>																					
		     </div>
       </li>
     </ul>

</body>
</html>