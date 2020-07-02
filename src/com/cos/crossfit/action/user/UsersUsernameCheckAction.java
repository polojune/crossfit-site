package com.cos.crossfit.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.model.Users;
import com.cos.crossfit.repository.UsersRepository;
import com.cos.crossfit.util.Script;

public class UsersUsernameCheckAction implements Action {
   @Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String username = request.getParameter("username"); 
	     
	     UsersRepository usersRepository = UsersRepository.getInstance(); 
	     Users user = usersRepository.findByUsername(username);
	     System.out.println("UsersUsernameCheckAction :" + user);
	     if(user == null) {
	    	  Script.outText("0", response);
	     }else {
	    	 Script.outText("1", response);
	     }
	     
	     
//	     Script.outText(result+"", response);
  }
}
