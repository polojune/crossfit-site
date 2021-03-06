package com.cos.crossfit.action.inquire;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.dto.InquireResponseDto;
import com.cos.crossfit.model.Inquire;

import com.cos.crossfit.repository.InquireRepository;
import com.cos.crossfit.repository.UsersRepository;

public class InquireHomeAction implements Action {
@Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String pageStr = request.getParameter("page");
	  int page; 
	  if(pageStr == null) { 
		    page= 0; 
	  }else {
		  page = Integer.parseInt(pageStr);
	  }
	  
	  //int userId = Integer.parseInt(request.getParameter("id"));
//	  UsersRepository usersRepository = UsersRepository.getInstance();
	  InquireRepository inquireRepository = InquireRepository.getInstance();
	  
	  
	  List<InquireResponseDto> posts = inquireRepository.listAll();
	  request.setAttribute("posts", posts);
	  int count = inquireRepository.count();
	  int lastPage = (count - 1) / 5; 
	  request.setAttribute("lastPage", lastPage);
	// System.out.println("InquireHomeAction : " + posts );
//	  List<Inquire> posts = inquireRepository.list();
//	  request.setAttribute("posts", posts);
//    
	
	RequestDispatcher dis = request.getRequestDispatcher("inquire.jsp");
	dis.forward(request, response);


	
    }
}
