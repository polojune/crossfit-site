package com.cos.crossfit.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.model.Users;
import com.cos.crossfit.repository.UsersRepository;
import com.cos.crossfit.util.Script;

public class UsersUpdateProcAction implements Action{
   @Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     HttpSession session = request.getSession(); 
	     if(session.getAttribute("principal") == null) { 
	    	 Script.getMessage("잘못된 접근입니다.", response);
	    	 return;
	     }
	  if
	    (
		       request.getParameter("id") == null || 
		       request.getParameter("id").equals("") || 
		       request.getParameter("password") == null || 
		       request.getParameter("password").equals("") || 
		       request.getParameter("email") == null ||  
		       request.getParameter("email").equals("")|| 
		       request.getParameter("address") == null || 
		       request.getParameter("address").equals("")
	  ) {
		   Script.back("입력되지 않은 필드가 있습니다.", response);
		   return;
	  }
	   
	  int id = Integer.parseInt(request.getParameter("id")); 
	  String password = request.getParameter("password"); 
	  String email = request.getParameter("email"); 
	  String address = request.getParameter("address");
	
	  Users user = Users.builder() 
			   .id(id)
			   .password(password)
			   .email(email)
			   .address(address)
			   .build();
	  UsersRepository usersRepository = UsersRepository.getInstance();
	  int result = usersRepository.update(user);
	
	  if(result == 1) { 
		  Users principal = usersRepository.findById(id); 
		  System.out.println("UsersUpdateProc : username : " + principal);
		  session.setAttribute("principal", principal);
		  
		  Script.href("회원수정 성공", "/crossfit/index.jsp", response);
	  }else {
		  Script.back("회원수정 실패", response);
	  }
 }
}
