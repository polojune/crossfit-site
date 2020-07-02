package com.cos.crossfit.action.inquire;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.dto.DetailResponseDto;
import com.cos.crossfit.dto.InquireReplyResponseDto;
import com.cos.crossfit.dto.InquireResponseDto;
import com.cos.crossfit.repository.InquireReplyRepository;
import com.cos.crossfit.repository.InquireRepository;
import com.cos.crossfit.util.Script;

public class InquireDetailAction implements Action {
  @Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     if(request.getParameter("id") == null || request.getParameter("id").equals("")
       
       ) {
    	  Script.back("잘못된 접근입니다.", response);
    	  return;
     }
	 
     int inquireId = Integer.parseInt(request.getParameter("id")); 
     
     InquireRepository inquireRepository = InquireRepository.getInstance();
     InquireReplyRepository inquireReplyRepository = InquireReplyRepository.getInstance();
     
     int result = inquireRepository.updateReadCount(inquireId);
     
     if(result != 1) {
    	 Script.back("서버오류", response);
    	 return;
     }
     
     InquireResponseDto inquireDto = inquireRepository.detail(inquireId);
     
     List<InquireReplyResponseDto> inquirereplyDtos = inquireReplyRepository.findAll(inquireId);
     
     System.out.println("InquireDetailAction : inquirereplyDtos.size() : " + inquirereplyDtos.size() + " : inquireId : " + inquireId);
     
     DetailResponseDto detailDto = DetailResponseDto.builder()
    		                       .inquireDto(inquireDto)
    		                       .inquirereplyDtos(inquirereplyDtos)
    		                       .build();
    		                     
                                   
    if(detailDto != null) {                               
     request.setAttribute("detailDto", detailDto);
     
     RequestDispatcher dis = request.getRequestDispatcher("inquireDetail.jsp"); 
     dis.forward(request, response);
    }else {
    	Script.back("잘못된 접근입니다.", response);
    }
  }
}
