package com.cos.crossfit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.action.board.BoardWodHomeAction;
import com.cos.crossfit.action.kakao.KakaoCallbackAction;
import com.cos.crossfit.action.kakao.KakaoJoinProcAction;
import com.cos.crossfit.action.board.BoardDeleteAction;
import com.cos.crossfit.action.board.BoardDetailAction;
import com.cos.crossfit.action.board.BoardSearchAction;
import com.cos.crossfit.action.board.BoardUpdateAction;
import com.cos.crossfit.action.board.BoardUpdateProcAction;
import com.cos.crossfit.action.board.BoardUploadProcAction;

@WebServlet("/oauth/kakao")
public class KakaoController extends HttpServlet {
	private final static String TAG = "KakaoController : ";
	private static final long serialVersionUID = 1L;

	public KakaoController() {
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
		
		HttpSession session = request.getSession();
		session.setAttribute("path", request.getContextPath());
		
		String cmd = request.getParameter("cmd");
		System.out.println(TAG + "router : " + cmd);
		Action action = router(cmd);
		
		action.execute(request, response);
	}
	
  public Action router(String cmd) {
	   System.out.println(TAG+"cmd: "+ cmd);
	   
	  if(cmd.equals("callback")) {
		      return new KakaoCallbackAction();

	   }else if(cmd.equals("joinProc")) {
		      return new KakaoJoinProcAction();
	   }
	   return null;  
  }
  
}
