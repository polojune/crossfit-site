package com.cos.crossfit.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.model.RoleType;
import com.cos.crossfit.model.Users;
import com.cos.crossfit.repository.UsersRepository;
import com.cos.crossfit.util.Script;

public class UsersLoginProcAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("username").equals("") || request.getParameter("username") == null
				|| request.getParameter("password").equals("") || request.getParameter("password") == null

		) {
			return;
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UsersRepository usersRepository = UsersRepository.getInstance();
		Users user = usersRepository.findByUsernameAndPassword(username, password);

		if (user != null) {
			HttpSession session = request.getSession();

			session.setAttribute("principal", user);

			if (request.getParameter("remember") != null) {
				Cookie cookie = new Cookie("remember", user.getUsername());
				cookie.setHttpOnly(true);
				response.addCookie(cookie);
			} else {
				Cookie cookie = new Cookie("remember", "");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			Script.href("로그인 성공", "/crossfit/index.jsp", response);
		} else {
			Script.back("로그인 실패", response);
		}

	}
}
