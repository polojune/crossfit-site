var isCheckedUsername = false;



function goPopup() {

	window.open("/crossfit/juso/jusoPopup.jsp", "pop",
			"width=570,height=420, scrollbars=yes, resizable=yes");

}

//juso.go.kr 라이브러리 함수(시작)-----------------------------------------------
function jusoCallBack(roadFullAddr) {
	var tfAddress = document.querySelector("#address");
	tfAddress.value = roadFullAddr;
	// document.form.roadFullAddr.value = roadFullAddr;
}


//중복체크 함수 
function validate() {
	// alert('나타?');
	if (!isCheckedUsername) {
		alert("아이디 중복체크를  해주세요");
	}

	return isCheckedUsername;
}
// 데이터베이스에 ajax 요청을 해서 중복 유저네임이 있는지 확인 
// 있으면 1을 리턴, 없으면 0을 리턴, 오류가 나면 -1을 리턴
function usernameCheck() {
	// 성공 (ajax)
	var tfUsername = $('#username').val();
	// alert(tfUsername);
	console.log(tfUsername);
	$.ajax({
		type : 'get',
		url : `/crossfit/user?cmd=usernameCheck&username=${tfUsername}`
	}).done(function(result) {
		console.log(result);
		if (result == 1) {
			alert("아이디가 중복되었습니다.");
		} else if (result == 0) {
			alert("사용하실 수 있는 아이디 입니다.");
			isCheckedUsername = true;
		} else {
			console.log('develop: 서버오류');
		}
	}).fail(function(error) {
		console.log(error);
	});
	// isCheckedUsername = true;
}
