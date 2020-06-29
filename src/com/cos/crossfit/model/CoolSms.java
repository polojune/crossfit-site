package com.cos.crossfit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoolSms {
     private String group_id; 
     private int success_count; 
     private int error_count;
}
