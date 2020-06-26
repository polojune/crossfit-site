package com.cos.crossfit.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.model.Board;
import com.cos.crossfit.repository.BoardRepository;
import com.cos.crossfit.util.Script;

public class BoardUpdateProcAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("admin") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return;
		}
		
		System.out.println("BoardUpdateProcAction: id :" + request.getParameter("id"));
		System.out.println("BoardUpdateProcAction: title :" + request.getParameter("title"));
		System.out.println("BoardUpdateProcAction: wodImage :" + request.getParameter("wodImage"));
		System.out.println("BoardUpdateProcAction: content :" + request.getParameter("content"));
		
		
		
		if (request.getParameter("id").equals("") || request.getParameter("id") == null
				|| request.getParameter("title").equals("") || request.getParameter("title") == null

				|| request.getParameter("content").equals("") || request.getParameter("content") == null

		) {
			return;
		}
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("BoardUpdateProcAction: id :" +id);
		String title = request.getParameter("title");
		System.out.println("BoardUpdateProcAction: title :" +title);
		String wodImage = request.getParameter("wodImage");
	
		String content = request.getParameter("content");
		
		Board board = Board.builder().id(id).title(title).wodImage(wodImage).content(content).build();
		BoardRepository boardRepository = BoardRepository.getInstance();

		int result = boardRepository.update(board);

		if (result == 1) {
			Script.href("수정성공", "/crossfit/board?cmd=detail&id=" + id, response);
		} else {
			Script.back("수정실패", response);
		}

	}
}
