package com.cos.crossfit.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailResponseDto {
   
	private InquireResponseDto inquireDto; 
	private List<InquireReplyResponseDto> inquirereplyDtos;
}
