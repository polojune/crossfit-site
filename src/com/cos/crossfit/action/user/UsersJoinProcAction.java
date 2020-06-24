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
	   String username = request.getParameter("username"); 
	   String password = request.getParameter("password"); 
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

