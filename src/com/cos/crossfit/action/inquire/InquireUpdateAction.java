package com.cos.crossfit.action.inquire;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.dto.InquireResponseDto;
import com.cos.crossfit.model.Board;
import com.cos.crossfit.model.Inquire;
import com.cos.crossfit.repository.BoardRepository;
import com.cos.crossfit.repository.InquireRepository;
import com.cos.crossfit.util.Script;

public class InquireUpdateAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") == null || request.getParameter("id").equals("")

		) {
			Script.back("잘못된 접근입니다.", response);
			return;
		}
		
		int id = Integer.parseInt(request.getParameter("id")); 
		InquireRepository inquireRepository = InquireRepository.getInstance(); 
	    InquireResponseDto inquireDto = inquireRepository.importPost(id); 
		if(inquireDto != null) {
			 request.setAttribute("inquireDto", inquireDto);
			 RequestDispatcher dis = request.getRequestDispatcher("updateForm.jsp"); 
			 dis.forward(request, response);
		}else {
			Script.back("잘못된 접근입니다.", response);
		}

	}
}
