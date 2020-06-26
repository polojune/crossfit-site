function replyWrite(boardId, userId) {
      console.log(userId);
	if(userId === undefined) { 
		alert("로그인이 필요합니다.");
		return;
	}
	
	
	var data = {
		boardId : boardId,
		userId : userId,
		content : $("#reply__write__form").val()
	// textarea일 경우 문자열을 가져옴, textarea부분의 value()값을 찾아옴
	};

	$.ajax({
		type : "post",
		url : "/crossfit/reply?cmd=writeProc",
		data : JSON.stringify(data),
		contentType : "application/json; charset-utf-8",
		dataType : "json"
	}).done(function(result) {
		// 정상 응답
		// 1. reply__list를 찾아서 내부를 비우기
		alert(result);
		if (result == -1 || result == 0) {
              alert("댓글 작성 실패");
			
		}else{
			  alert("댓글 작성 성공");
			  $("#reply__list").empty();
			  console.log(result); 
			  renderReplyList(result,userId);
			  $("#reply__write__form").val("");
		}
		// 2. ajax 재호출 findAll()

		// 3. reply__list를 찾아서 내부에 채워주기
	}).fail(function(error) {
           alert("댓글 작성 실패");
	});

}