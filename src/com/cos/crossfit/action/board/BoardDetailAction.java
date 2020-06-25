package com.cos.crossfit.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.model.Board;
import com.cos.crossfit.repository.BoardRepository;
import com.cos.crossfit.util.HtmlParser;
import com.cos.crossfit.util.Script;

public class BoardDetailAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      if(request.getParameter("id") == null || 
	    	 request.getParameter("id").equals("")
	    	 ) {
	    	  Script.back("잘못된 접근입니다.", response);
	    	  return;
	      }
        int boardId = Integer.parseInt(request.getParameter("id"));
        BoardRepository boardRepository = BoardRepository.getInstance();
        Board boardDetail = boardRepository.detail(boardId);
      
        
        if(boardDetail != null) {
                String content = boardDetail.getContent();
                content = HtmlParser.getContentToutube(content); 
                boardDetail.setContent(content);
                
                request.setAttribute("boardDetail", boardDetail);
                RequestDispatcher dis = request.getRequestDispatcher("detail.jsp");
                dis.forward(request, response);
                
        }
        
      
        
	}
}
