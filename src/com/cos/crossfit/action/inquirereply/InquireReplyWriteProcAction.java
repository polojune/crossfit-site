package com.cos.crossfit.action.inquirereply;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.dto.InquireReplyResponseDto;
import com.cos.crossfit.dto.ReplyResponseDto;
import com.cos.crossfit.model.InquireReply;
import com.cos.crossfit.model.Reply;
import com.cos.crossfit.repository.InquireReplyRepository;
import com.cos.crossfit.repository.ReplyRepository;
import com.cos.crossfit.util.Script;
import com.google.gson.Gson;

public class InquireReplyWriteProcAction implements Action{
     @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   
    	 BufferedReader br = request.getReader(); 
    	 StringBuffer sb = new StringBuffer(); 
    	 String input = null; 
    	 while ((input = br.readLine()) != null) {
    		 sb.append(input);
    	 }
    	 System.out.println("input:" + sb.toString());
    	 Gson gson = new Gson();
    	 InquireReply inquireReply = gson.fromJson(sb.toString(), InquireReply.class);
    	 
    	 InquireReplyRepository inquirereplyRepository = InquireReplyRepository.getInstance();
    	 int result = inquirereplyRepository.save(inquireReply); 
    	 
    	 if(result == 1) { 
    		 List<InquireReplyResponseDto> inquirereplyDtos = inquirereplyRepository.findAll(inquireReply.getInquireId());
    		 String inquirereplyDtosJson = gson.toJson(inquirereplyDtos);
    		 System.out.println("InquireReplyWriteProcAction : inquirereplyDtosJson : " + inquirereplyDtos);
    		 Script.outJson(inquirereplyDtosJson, response);
    	 }else {
    		 Script.outJson(result + "" , response);
    	 }
    	
    }
}
