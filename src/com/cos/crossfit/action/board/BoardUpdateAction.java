package com.cos.crossfit.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.model.Board;
import com.cos.crossfit.repository.BoardRepository;
import com.cos.crossfit.util.Script;

public class BoardUpdateAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") == null || request.getParameter("id").equals("")

		) {
			Script.back("잘못된 접근입니다.", response);
			return;
		}
		
		int id = Integer.parseInt(request.getParameter("id")); 
		BoardRepository boardRepository = BoardRepository.getInstance(); 
		Board board = boardRepository.findById(id); 
		if(board != null) {
			 request.setAttribute("board", board);
			 RequestDispatcher dis = request.getRequestDispatcher("boardupdate.jsp"); 
			 dis.forward(request, response);
		}else {
			Script.back("잘못된 접근입니다.", response);
		}

	}
}
