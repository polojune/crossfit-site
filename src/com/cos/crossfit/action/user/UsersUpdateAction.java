package com.cos.crossfit.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.util.Script;

public class UsersUpdateAction implements Action{
  @Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           HttpSession session = request.getSession(); 
           if(session.getAttribute("principal") == null) { 
        	   Script.getMessage("잘못된 접근입니다.", response);
        	   return;
           }
          RequestDispatcher dis = request.getRequestDispatcher("update.jsp");
          dis.forward(request, response);
           
	
  }
}
