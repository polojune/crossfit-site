package com.cos.crossfit.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InquireReply {
         private int id; 
         private int userId; 
         private int inquireId; 
         private String content; 
         private Timestamp createDate;
}
