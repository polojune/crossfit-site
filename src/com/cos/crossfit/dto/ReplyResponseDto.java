package com.cos.crossfit.dto;

import com.cos.crossfit.model.Reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ReplyResponseDto {
      private Reply reply; 
      private String username; 
      private String userProfile;
}
