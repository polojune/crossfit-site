package com.cos.crossfit.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.model.Board;
import com.cos.crossfit.model.Users;
import com.cos.crossfit.repository.BoardRepository;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardUploadProcAction implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String realPath = request.getServletContext().getRealPath("images");
  
    	 String fileName = null; 
    	 String contextPath = request.getServletContext().getContextPath();
    	 String wodImage = null;
    	 System.out.println("realPath:" + realPath);
         System.out.println("contextPath : " + contextPath);
	     
         try {
			MultipartRequest multi = new MultipartRequest(request, realPath,1024*1024*2,"UTF-8",new DefaultFileRenamePolicy());
			fileName = multi.getFilesystemName("fileName");
			System.out.println("fileName:" + fileName);
			String title = multi.getParameter("title"); 
			String content = multi.getParameter("content");
			System.out.println("BoardUploadProcAction : title"+title);
			System.out.println("BoardUploadProcAction : content"+content);
        	wodImage = contextPath+"/images/" + fileName; 
        	
//        	HttpSession session = request.getSession();
//        	Users user = (Users) session.getAttribute("");
        	
        	Board board = Board.builder()
        		   //.id(user.getId())
        	       .wodImage(wodImage)
        	       .title(title)
        	       .content(content)
        	       .build();
        	
        	BoardRepository boardRepository = BoardRepository.getInstance();
        	int result = boardRepository.save(board);
        	System.out.println("BoardUploadAction:result:"+ result);
            
        		
        	
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
