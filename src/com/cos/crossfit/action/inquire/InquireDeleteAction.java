package com.cos.crossfit.action.inquire;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.repository.BoardRepository;
import com.cos.crossfit.repository.InquireRepository;
import com.cos.crossfit.util.Script;

public class InquireDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return;
		}
		if (request.getParameter("id") == null || request.getParameter("id").equals("")) {
			return;
		}

		int id = Integer.parseInt(request.getParameter("id"));

		InquireRepository inquireRepository = InquireRepository.getInstance();
		int result = inquireRepository.deleteById(id);

		System.out.println("InquireDeleteAction : result : " + result);

		if (result == 1) {
          Script.href("삭제 성공", "/crossfit/inquire?cmd=inquireHome", response);
		    
		} else {
			Script.back("삭제실패", response);
		}
	}
}
