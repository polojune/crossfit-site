package com.cos.crossfit.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.repository.BoardRepository;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWodImageUploadProcAction implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String realPath = request.getServletContext().getRealPath("images");
    	 int id; 
    	 String fileName = null; 
    	 String contextPath = request.getServletContext().getContextPath();
    	 String wodImage = null;
    	 System.out.println("realPath:" + realPath);
         System.out.println("contextPath : " + contextPath);
	     
         try {
			MultipartRequest multi = new MultipartRequest(request, realPath,1024*1024*2,"UTF-8",new DefaultFileRenamePolicy());
			fileName = multi.getFilesystemName("wodImage");
			System.out.println("fileName:" + fileName);
			id = Integer.parseInt(multi.getParameter("id"));
        	 
        	wodImage = contextPath+"/images/" + fileName; 
        	
        	BoardRepository boardRepository = BoardRepository.getInstance();
        	
        	int result = boardRepository.update(id,wodImage);
        	
        	if(result == 1) {
        		HttpSession session = request.getSession();
        		
        	}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}
