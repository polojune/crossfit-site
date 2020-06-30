package com.cos.crossfit.action.inquire;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.model.Inquire;

import com.cos.crossfit.repository.InquireRepository;

public class InquireAction implements Action {
@Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	InquireRepository inquireRepository = InquireRepository.getInstance();
	List<Inquire> posts = inquireRepository.list();
	request.setAttribute("posts", posts);
    
	
	RequestDispatcher dis = request.getRequestDispatcher("inquire.jsp");
	dis.forward(request, response);


	
    }
}
