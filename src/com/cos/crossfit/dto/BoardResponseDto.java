package com.cos.crossfit.dto;

import java.util.List;

import com.cos.crossfit.model.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BoardResponseDto {
      private Board board; 
      private List<ReplyResponseDto> replyDtos;
}
