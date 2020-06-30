package com.cos.crossfit.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.model.Board;
import com.cos.crossfit.repository.BoardRepository;
import com.cos.crossfit.util.Script;

public class BoardSearchAction implements Action {
   @Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   if(request.getParameter("keyword") == null || 
				  request.getParameter("keyword").equals("")) {
			Script.back("검색 키워드가 없습니다", response);
			return;
		}
	   System.out.println("BoardSearchAction:" + request.getParameter("keyword"));
	   
	   BoardRepository boardRepository = BoardRepository.getInstance(); 
	   
	   int page = Integer.parseInt(request.getParameter("page"));
	   String keyword = request.getParameter("keyword"); 
	   List<Board>boards = boardRepository.findAll(page,keyword);
	   
	   request.setAttribute("boards", boards);
	   
	   
	   int count = boardRepository.count(keyword);
	   int lastPage = (count-1)/3;
	   request.setAttribute("lastPage", lastPage);
	   
	   RequestDispatcher dis = request.getRequestDispatcher("wod.jsp"); 
	   dis.forward(request, response);
	   
    }
}
