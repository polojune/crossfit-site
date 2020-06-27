package com.cos.crossfit.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.crossfit.db.DBConn;
import com.cos.crossfit.dto.ReplyResponseDto;
import com.cos.crossfit.model.Reply;

public class ReplyRepository {

	private static final String TAG = "ReplyRepository :";
	private static ReplyRepository instance = new ReplyRepository();

	public ReplyRepository() {
	}

	public static ReplyRepository getInstance() {

		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	
	public int deleteById(int id) {
		final String SQL ="DELETE FROM reply WHERE id = ?";
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
	
	public List<ReplyResponseDto> findAll(int boardId) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT r.id, r.userId, r.boardId,r.content,r.createDate, ");
		sb.append("u.username, u.userProfile ");
		sb.append("FROM reply r INNER JOIN users u ");
		sb.append("ON r.userId = u.id ");
		sb.append("WHERE boardId = ? ");
		sb.append("ORDER BY r.id DESC");
		final String SQL =sb.toString();
	    List<ReplyResponseDto> replyDtos = null;
		try {
	    		conn = DBConn.getConnection();
	    		pstmt = conn.prepareStatement(SQL);
		       //물음표 완성하기
	           pstmt.setInt(1, boardId);
	    	   rs = pstmt.executeQuery();
	           //while 돌려서 rs -> java 오브젝트 집어 넣기	
	    	   replyDtos = new ArrayList<>();
	    	   while(rs.next()) {
	    		   Reply reply = Reply.builder()
	    				   .id(rs.getInt(1))
	    				   .userId(rs.getInt(2))
	    				   .boardId(rs.getInt(3))
	    				   .content(rs.getString(4))
	    				   .createDate(rs.getTimestamp(5))
	    				   .build();
	    		   ReplyResponseDto replyDto = ReplyResponseDto.builder()
	    				   .reply(reply)
	    				   .username(rs.getString(6))
	    				   .userProfile(rs.getString(7))
	    				   .build();
	    		   replyDtos.add(replyDto);
	    		   
	    	   }
	    		return replyDtos;
	     } catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(TAG+"findAll(boardId) : "+e.getMessage());
		}finally {
			 DBConn.close(conn,pstmt,rs);
		   	 
		}
		return null;
	}
	
	public int save(Reply reply) {
		final String SQL = "INSERT INTO reply (id,userId,boardId,content,createDate) VALUES(REPLY_SEQ.NEXTVAL, ?,?,?,SYSDATE)";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기

			pstmt.setInt(1, reply.getUserId());
			pstmt.setInt(2, reply.getBoardId());
			pstmt.setString(3, reply.getContent());
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
