package com.cos.crossfit.dto;

import com.cos.crossfit.model.Inquire;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class InquireResponseDto {
      private Inquire inquire; 
      private String username;
}
