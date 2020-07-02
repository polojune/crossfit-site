package com.cos.crossfit.action.inquirereply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.repository.InquireReplyRepository;
import com.cos.crossfit.repository.ReplyRepository;
import com.cos.crossfit.util.Script;

public class InquireReplyDeleteProcAction implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  if(request.getParameter("inquireReplyId") == null ||
	    		   request.getParameter("inquireReplyId").equals("")) {
	    	   return;
	       }
    	    int inquireReplyId = Integer.parseInt(request.getParameter("inquireReplyId")); 
 	       System.out.println("InquireReplyDeleteProcAction: inquireReplyId" + inquireReplyId);
 	       
 	       InquireReplyRepository inquirereplyRepository = InquireReplyRepository.getInstance(); 
 	       
 	       int result = inquirereplyRepository.deleteById(inquireReplyId);
           Script.outText(result+"", response);    	 		      
    	
    }
}
