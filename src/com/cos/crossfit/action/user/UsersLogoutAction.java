package com.cos.crossfit.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.util.Script;

public class UsersLogoutAction implements Action{
  @Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(); 
        session.invalidate();
        
        Script.href("로그아웃 성공", "index.jsp", response);
}
}
