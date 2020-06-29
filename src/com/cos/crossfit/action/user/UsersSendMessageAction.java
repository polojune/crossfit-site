package com.cos.crossfit.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.model.CoolSms;
import com.cos.crossfit.util.Script;
import com.cos.crossfit.util.SmsApp;
import com.google.gson.Gson;

public class UsersSendMessageAction implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	     SmsApp app = new SmsApp();
    	    
    	     String message = request.getParameter("message");
    	     System.out.println("UsersSendMessageAction:" + message);
    	     
    	     JSONObject obj = app.send("01027258574", message);
    	     System.out.println("UsersSendMessageAction:" + obj);
    	      
    	     Gson gson = new Gson(); 
        	 CoolSms sns = gson.fromJson(obj.toJSONString(), CoolSms.class);
    	    
        	if(sns.getSuccess_count() == 1) {
        		Script.href("문자보내기 성공", "/crossfit/home.jsp", response);
        	}else {
        		Script.back("문자보내기 실패", response);
        	}
    }
}
