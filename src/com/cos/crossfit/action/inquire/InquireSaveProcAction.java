package com.cos.crossfit.action.inquire;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.model.Inquire;
import com.cos.crossfit.repository.InquireRepository;
import com.cos.crossfit.util.Script;

public class InquireSaveProcAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("principal") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		int userId = Integer.parseInt(request.getParameter("userId"));
        System.out.println("InquireSaveProcAction :" + userId );
		String title = request.getParameter("title");
		System.out.println("InquireSaveProcAction :" + title );
		String content = request.getParameter("content");
  		System.out.println("InquireSaveProcAction :" + content);
       
  		Inquire inquire = Inquire.builder() 
  				.userId(userId)
  				.title(title)
  				.content(content)
  				.readCount(0)
  				.build();
 		 		 		
  		InquireRepository inquireRepository = InquireRepository.getInstance();
		int result = inquireRepository.save(inquire);

		if (result == 1) {
			Script.href("글쓰기성공", "inquire.jsp", response);
		} else {
			Script.back("글쓰기 실패", response);
		}
	}
}
