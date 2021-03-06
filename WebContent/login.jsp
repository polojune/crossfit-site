<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%> 


<br><br><br><br><br><br><br>
<div class="container">
	<form action="/crossfit/user?cmd=loginProc" method="POST" class="was-validated" style="width:285px; margin: 0 auto;">
		<div class="form-group">
			<label for="username">Username:</label> <input type="text" style="width:100%" value="${cookie.remember.value}" class="form-control" id="username" placeholder="Enter username" name="username" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		
		<div class="form-group">
			<label for="pwd">Password:</label> <input type="password" style="width:100%"  class="form-control" id="password" placeholder="Enter password" name="password" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<div class="form-group form-check">
			<label class="form-check-label"> <c:choose>
					<c:when test="${empty cookie.remember}">
						<input class="form-check-input" type="checkbox" name="remember"> 아이디 기억하기
      	</c:when>
					<c:otherwise>
						<input class="form-check-input" type="checkbox" name="remember" checked> 아이디 기억하기
      	</c:otherwise>
				</c:choose>
			</label>
		</div>
		<button type="submit" class="btn btn-primary">로그인</button>
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=4584fffce1f6805d84fb7ce6a9906c99&redirect_uri=http://localhost:8000/crossfit/oauth/kakao?cmd=callback&response_type=code"><img height="38px" src="/crossfit/images/kakao_login_button.png"></a>
	</form>
  </div>

<%@ include file="/include/footer.jsp"%>  