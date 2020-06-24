package com.cos.crossfit.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.repository.UsersRepository;
import com.cos.crossfit.util.Script;

public class UsersUsernameCheckAction implements Action {
   @Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String username = request.getParameter("username"); 
	     
	     UsersRepository usersRepository = UsersRepository.getInstance(); 
	     int result = usersRepository.findByUsername(username);
	     System.out.println("UsersUsernameCheckAction :" + result);
	     Script.outText(result+"", response);
  }
}
