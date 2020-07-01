package com.cos.crossfit.action.inquire;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.dto.InquireResponseDto;
import com.cos.crossfit.model.Board;
import com.cos.crossfit.model.Inquire;
import com.cos.crossfit.repository.BoardRepository;
import com.cos.crossfit.repository.InquireRepository;
import com.cos.crossfit.util.Script;

public class InquireUpdateProcAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return;
		}
		
		
		
		if (request.getParameter("id").equals("") || request.getParameter("id") == null
				|| request.getParameter("username").equals("") || request.getParameter("username") == null
				|| request.getParameter("title").equals("") || request.getParameter("title") == null

				|| request.getParameter("content").equals("") || request.getParameter("content") == null

		) {
			return;
		}
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("InquireUpdateProcAction: id :" +id);
		String title = request.getParameter("title");
		System.out.println("InquireUpdateProcAction: title :" +title);
	  	String content = request.getParameter("content");
		
	
		   Inquire inquire = Inquire.builder() 
				            .id(id)
				            .title(title)
				            .content(content)
				            .build();
		         
		InquireRepository inquireRepository = InquireRepository.getInstance();
     
		int result = inquireRepository.update(inquire);

		if (result == 1) {
			Script.href("수정성공", "/crossfit/inquire?cmd=detail&id=" + id, response);
		} else {
			Script.back("수정실패", response);
		}

	}
}
