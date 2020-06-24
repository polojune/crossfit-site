package com.cos.crossfit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.action.board.BoardWodHomeAction;
import com.cos.crossfit.action.board.BoardWodImageUploadProcAction;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private final static String TAG = "BoardController";
	private static final long serialVersionUID = 1L;

	public BoardController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		System.out.println(TAG + "router : " + cmd);
		Action action = router(cmd);
		action.execute(request, response);
	}
  public Action router(String cmd) {
	   if(cmd.equals("home")) {
		    
		   return new BoardWodHomeAction();
	   }else if(cmd.equals("wodImageUploadProc")) {
		    
		   return new BoardWodImageUploadProcAction();
	   }
	   return null;  
  }
  
}
