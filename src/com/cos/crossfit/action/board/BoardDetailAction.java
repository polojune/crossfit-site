package com.cos.crossfit.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.dto.BoardResponseDto;
import com.cos.crossfit.dto.ReplyResponseDto;
import com.cos.crossfit.model.Board;
import com.cos.crossfit.repository.BoardRepository;
import com.cos.crossfit.repository.ReplyRepository;
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
        ReplyRepository replyRepository = ReplyRepository.getInstance();
      
 
        Board board = boardRepository.detail(boardId);
       
        List<ReplyResponseDto> replyDtos = replyRepository.findAll(boardId);
        
        BoardResponseDto detailDto = BoardResponseDto.builder()
        		                     .board(board)
        		                     .replyDtos(replyDtos)
        		                     .build();
        
        
        if(detailDto != null) {
                String content = detailDto.getBoard().getContent();
                content = HtmlParser.getContentYoutube(content); 
                detailDto.getBoard().setContent(content);
                
//                request.setAttribute("boardDetail", boardDetail);
                request.setAttribute("detailDto", detailDto);
                
                RequestDispatcher dis = request.getRequestDispatcher("detail.jsp");
                dis.forward(request, response);
                
        }
        
      
        
	}
}
