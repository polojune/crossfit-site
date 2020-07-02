package com.cos.crossfit.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.crossfit.db.DBConn;
import com.cos.crossfit.dto.InquireReplyResponseDto;
import com.cos.crossfit.dto.ReplyResponseDto;
import com.cos.crossfit.model.InquireReply;
import com.cos.crossfit.model.Reply;

public class InquireReplyRepository {

	private static final String TAG = "ReplyRepository :";
	private static InquireReplyRepository instance = new InquireReplyRepository();

	public InquireReplyRepository() {
	}

	public static InquireReplyRepository getInstance() {

		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	
	public int deleteById(int id) {
		final String SQL ="DELETE FROM inquirereply WHERE id = ?";
	     try {
	    		conn = DBConn.getConnection();
	    		pstmt = conn.prepareStatement(SQL);
		       //물음표 완성하기
	            pstmt.setInt(1, id);
	    		return pstmt.executeUpdate();
	     } catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(TAG+"deleteById : "+e.getMessage());
		}finally {
			 DBConn.close(conn,pstmt);
		   	 
		}
		return -1;
	}	
	
	public List<InquireReplyResponseDto> findAll(int inquireId) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT i.id, i.userId, i.inquireId,i.content,i.createDate, ");
		sb.append("u.username, u.userProfile ");
		sb.append("FROM inquirereply i INNER JOIN users u ");
		sb.append("ON i.userId = u.id ");
		sb.append("WHERE inquireId = ? ");
		sb.append("ORDER BY i.id DESC");
		final String SQL =sb.toString();
	    List<InquireReplyResponseDto> inquirereplyDtos = null;
		try {
	    		conn = DBConn.getConnection();
	    		pstmt = conn.prepareStatement(SQL);
		       //물음표 완성하기
	           pstmt.setInt(1, inquireId);
	    	   rs = pstmt.executeQuery();
	           //while 돌려서 rs -> java 오브젝트 집어 넣기	
	    	   inquirereplyDtos = new ArrayList<>();
	    	   while(rs.next()) {
	    		   InquireReply inquirereply = InquireReply.builder()
	    				   .id(rs.getInt(1))
	    				   .userId(rs.getInt(2))
	    				   .inquireId(rs.getInt(3))
	    				   .content(rs.getString(4))
	    				   .createDate(rs.getTimestamp(5))
	    				   .build();
	    		   InquireReplyResponseDto inquirereplyDto = InquireReplyResponseDto.builder()
	    				   .inquirereply(inquirereply)
	    				   .username(rs.getString(6))
	    				   .userProfile(rs.getString(7))
	    				   .build();
	    		   inquirereplyDtos.add(inquirereplyDto);
	    		   
	    	   }
	    		return inquirereplyDtos;
	     } catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(TAG+"findAll(inquireId) : "+e.getMessage());
		}finally {
			 DBConn.close(conn,pstmt,rs);
		   	 
		}
		return null;
	}
	
	public int save(InquireReply inquirereply) {
		final String SQL = "INSERT INTO inquirereply (id,userId,inquireId,content,createDate) VALUES(REPLY_SEQ.NEXTVAL, ?,?,?,SYSDATE)";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기

			pstmt.setInt(1, inquirereply.getUserId());
			pstmt.setInt(2, inquirereply.getInquireId());
			pstmt.setString(3, inquirereply.getContent());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "save : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);

		}
		return -1;
	}
}
