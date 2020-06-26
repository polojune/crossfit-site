package com.cos.crossfit.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.model.Board;
import com.cos.crossfit.repository.BoardRepository;
import com.cos.crossfit.util.HtmlParser;

public class BoardWodHomeAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageStr = request.getParameter("page");
		int page;
		if (pageStr == null) {
			page = 0;
		} else {
			page = Integer.parseInt(pageStr);
		}

		BoardRepository boardRepository = BoardRepository.getInstance();

		List<Board> boards = boardRepository.findAll(page);
		
		// 본문 짧게 가공하기/		
		for (Board board : boards) {
			String preview = HtmlParser.getContentPreview(board.getContent());
		board.setContent(preview);

		}

		
		request.setAttribute("boards", boards);
         int count = boardRepository.count();
         int lastPage = (count - 1) / 3; 
         request.setAttribute("lastPage", lastPage);
		
		//		System.out.println("BoardWodHomeAction : boards :" + boards);
		HttpSession session = request.getSession();
		session.setAttribute("backPage", page);
		session.setAttribute("backKeyword", null);

		
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length>= 1) {
			for (Cookie cookie : cookies) {
				System.out.println("BoardWodHomeAction : cookie.getName() : " + cookie.getName() + "  : cookie.getValue() :" + cookie.getValue());
			}
		}
		
		System.out.println("BoardWodHomeAction : session.getAttribute('admin') : " + session.getAttribute("admin"));
		System.out.println("BoardWodHomeAction : session.getAttribute('principal') : " + session.getAttribute("principal"));
		
		
		
		RequestDispatcher dis = request.getRequestDispatcher("wod.jsp");
		dis.forward(request, response);
	}
}
