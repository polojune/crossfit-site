package com.cos.crossfit.action.reply;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.dto.ReplyResponseDto;
import com.cos.crossfit.model.Reply;
import com.cos.crossfit.repository.ReplyRepository;
import com.cos.crossfit.util.Script;
import com.google.gson.Gson;

public class ReplyWriteProcAction implements Action{
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
    	 Reply reply = gson.fromJson(sb.toString(), Reply.class);
    	 
    	 ReplyRepository replyRepository = ReplyRepository.getInstance();
    	 int result = replyRepository.save(reply); 
    	 
    	 if(result == 1) { 
    		 List<ReplyResponseDto> replyDtos = replyRepository.findAll(reply.getBoardId());
    		 String replyDtosJson = gson.toJson(replyDtos);
    		 System.out.println("ReplyWriteProcAction : replyDtosJson : " + replyDtosJson);
    		 Script.outJson(replyDtosJson, response);
    	 }else {
    		 Script.outJson(result + "" , response);
    	 }
    	
    }
}
