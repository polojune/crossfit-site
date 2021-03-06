package com.cos.crossfit.action.kakao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.model.RoleType;
import com.cos.crossfit.model.Users;
import com.cos.crossfit.repository.UsersRepository;
import com.cos.crossfit.util.Script;

public class KakaoJoinProcAction implements Action{
   @Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 0. 유효성 검사
			if
			(
					request.getParameter("username") == null ||
					request.getParameter("username").equals("") ||
					request.getParameter("email") == null ||
					request.getParameter("email").equals("")

			) {
				return;
			}

			// 1. 파라메터 받기 (x-www-form-urlencoded 라는 MIME타입 key=value)
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String userRole = RoleType.USER.toString();

			// 2. User 오브젝트 변환
			Users user = Users.builder()
					.username(username)
					.password("")
					.email(email)
					.address("")
					.userRole(userRole)
					.build();

			// 3. DB연결 - UsersRepository의 save() 호출
			UsersRepository usersRepository = 
					UsersRepository.getInstance();
			int result = usersRepository.save(user);

			// 4. index.jsp 페이지로 이동
			if(result == 1) {
				Script.href("회원가입에 성공하였습니다.", "/crossfit/user?cmd=login", response);
			}else {
				Script.back("회원가입에 실패하였습니다.", response);
			}
		}

	}
	
 


