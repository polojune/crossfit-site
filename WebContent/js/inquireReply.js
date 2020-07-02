function replyDelete(inquireReplyId) {
  	$.ajax({
		type : "post",
		url : "/crossfit/inquirereply?cmd=deleteProc",
		data : "inquireReplyId="+inquireReplyId,
		contentType : "application/x-www-form-urlencoded; charset-utf-8",
		dataType : "text"
	}).done(function(result) {
	     if(result =="1"){
		 alert("댓글 삭제 성공");
	     var replyItem = $("#reply-" +inquireReplyId); 
	     replyItem.remove();
	     }else{
	    	  alert("댓글 삭제 실패");
	     }    
	}).fail(function(error) {
           alert("댓글 삭제 실패");
	});

}


function replyWrite(inquireId, userId) {
      alert(inquireId);  
	console.log(userId);
	if(userId === undefined) { 
		alert("로그인이 필요합니다.");
		return;
	}
	
	console.log(userId);
	var data = {
		inquireId : inquireId,
		userId : userId,
		content : $("#content__form").val()
	// textarea일 경우 문자열을 가져옴, textarea부분의 value()값을 찾아옴
	};

	$.ajax({
		type : "post",
		url : "/crossfit/inquirereply?cmd=writeProc",
		data : JSON.stringify(data),
		contentType : "application/json; charset-utf-8",
		dataType : "json"
	}).done(function(result) {
		// 정상 응답
		// 1. reply__list를 찾아서 내부를 비우기
		//alert(result);
		if (result == -1 || result == 0) {
              alert("댓글 작성 실패");
			
		}else{
			  alert("댓글 작성 성공");
			  $("#reply__list").empty();
			  console.log(result); 
		      renderReplyList(result,userId);
			  $("#content__form").val("");
		}
		// 2. ajax 재호출 findAll()

		// 3. reply__list를 찾아서 내부에 채워주기
	}).fail(function(error) {
           alert("댓글 작성 실패");
	});

}

function renderReplyList(inquirereplyDtos,userId){
	for(var inquirereplyDto of inquirereplyDtos){
		$("#reply__list").append(makeReplyItem(inquirereplyDto,userId));
	}
}
function makeReplyItem(inquirereplyDto,userId){
//	//reply-id 추가시작
	var replyItem = `<li id="reply-${inquirereplyDto.inquirereply.id}"  class="media">`;
//	// reply-id 추가 끝
//	
	replyItem += `<img src="/crossfit/images/userProfile.png" alt="" class="img-circle">`;	
	replyItem += `<div class="media-body">`;
	replyItem += `<strong class="text-primary">${inquirereplyDto.username}</strong>`;
	replyItem += `<p>${inquirereplyDto.inquirereply.content}</p>`;
	replyItem += `</div>`;
	//휴지통 추가 시작 
	replyItem += `<div class="m-2">`;
    if(inquirereplyDto.inquirereply.userId == userId){
	replyItem += `<i onclick="replyDelete(${inquirereplyDto.inquirereply.id})" style="font-size:20px;color:black; cursor:pointer" class="fas fa-trash"></i>`;
    } 
	replyItem += `</div>`;
	//휴지통 추가 끝
	replyItem += `</li>`;
	
	return replyItem;
}
