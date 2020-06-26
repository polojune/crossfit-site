package com.cos.crossfit.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.repository.BoardRepository;
import com.cos.crossfit.util.Script;

public class BoardDeleteAction implements Action{
   @Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession(); 
            if(session.getAttribute("admin") == null) {
            	Script.getMessage("잘못된 접근입니다.", response);
            	return;
            }
            if (request.getParameter("id") == null || request.getParameter("id").equals("")) {
    			return;
    		}  
            
            int id = Integer.parseInt(request.getParameter("id")); 
            
            BoardRepository boardRepository = BoardRepository.getInstance();
            int result = boardRepository.deleteById(id); 
            
            System.out.println("BoardDeleteAction : result : " + result);
    	    
    		if(result == 1) {
    		
    			int backpage	= (Integer) session.getAttribute("backPage");
    			RequestDispatcher dis = request.getRequestDispatcher("/board?cmd=wod&page=" + backpage); 
    			dis.forward(request, response);
    			
    		}else {
    			Script.back("삭제실패", response);
    		}
   }
}
