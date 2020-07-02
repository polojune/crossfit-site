package com.cos.crossfit.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.model.RoleType;
import com.cos.crossfit.model.Users;
import com.cos.crossfit.repository.UsersRepository;
import com.cos.crossfit.util.Script;

public class UsersJoinProcAction implements Action{
   @Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    if
	       ( 
	    	   request.getParameter("username").equals("") || 
	    	   request.getParameter("username")== null || 
	    	   request.getParameter("password").equals("") ||
	    	   request.getParameter("password") == null||
	    	   request.getParameter("email").equals("") ||
	    	   request.getParameter("email") == null || 
	    	   request.getParameter("address").equals("") || 
	    	   request.getParameter("address") == null
	         ) { 		   
	      return;		   
	}    		   
		// 카카오 아이디와 구분하기 위해 회원가입시 _를 받지 않는다.
		if(request.getParameter("username").contains("_")) {
			Script.back("회원 아이디에 _를 넣을 수 없습니다.", response);
			return;
		}

	   String username = request.getParameter("username").trim(); 
	   String password = request.getParameter("password").trim(); 
	   String email = request.getParameter("email"); 
	   String address = request.getParameter("address");
	   String userRole = RoleType.USER.toString();
	   
	   Users user = Users.builder() 
			   .username(username)
			   .password(password)
			   .email(email)
			   .address(address)
			   .userRole(userRole)
			   .build();
	  
	   UsersRepository usersRepository = UsersRepository.getInstance();
	   int result = usersRepository.save(user);
	    System.out.println("result:" + result);
	   if(result == 1) { 
		     Script.href("회원가입에 성공하였습니다.","/crossfit/user?cmd=login" , response);
		     
	   }else { 
		      Script.back("회원가입에 실패하였습니다.", response);
	   }
   }	    		  
}

