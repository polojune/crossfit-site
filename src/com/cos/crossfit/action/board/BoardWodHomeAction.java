package com.cos.crossfit.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.model.Board;
import com.cos.crossfit.repository.BoardRepository;

public class BoardWodHomeAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int page = Integer.parseInt(request.getParameter("page"));

		BoardRepository boardRepository = BoardRepository.getInstance();

		List<Board> boards = boardRepository.findAll(page);
		request.setAttribute("boards", boards);

		HttpSession session = request.getSession();
		session.setAttribute("backPage", page);
		session.setAttribute("backKeyword", null);

		RequestDispatcher dis = request.getRequestDispatcher("/crossfit/wod.jsp");
		dis.forward(request, response);
	}
}
