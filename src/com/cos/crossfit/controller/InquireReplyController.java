package com.cos.crossfit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.action.reply.ReplyDeleteProcAction;
import com.cos.crossfit.action.reply.ReplyWriteProcAction;

@WebServlet("/inqurereply")
public class InquireReplyController extends HttpServlet {
	private final static String TAG = "ReplyController";
	private static final long serialVersionUID = 1L;

	public InquireReplyController() {
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
		   if(cmd.equals("writeProc")) {
			    //회원 가입 페이지로 이동
		    return new ReplyWriteProcAction();   
		   
		   }if(cmd.equals("deleteProc")) {
			    //회원 가입 페이지로 이동
		    return new ReplyDeleteProcAction();   
		   
		   }	  	   
		   return null;
	    
	   } 

}
