package com.cos.crossfit.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.crossfit.db.DBConn;
import com.cos.crossfit.model.Board;
import com.cos.crossfit.model.Users;

public class BoardRepository {
	private static final String TAG = "BoardRepository : ";
	private static BoardRepository instance = new BoardRepository();

	public BoardRepository() {
	}

	public static BoardRepository getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
    
	
	public int save(Board board) {
		final String SQL = "INSERT INTO board(id,wodImage,title,content,createDate) VALUES(BOARD_SEQ.NEXTVAL, ?,?,?,SYSDATE)";

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, board.getWodImage());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
	

			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(TAG + "save : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public Board detail(int id) {
		
		final String SQL = "SELECT * FROM board WHERE id = ? ";
		Board board = null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setInt(1, id);
		
			rs = pstmt.executeQuery();
			if(rs.next()) { 
			 board = Board.builder()
					 .id(rs.getInt("id"))
					 .userId(rs.getInt("userId"))
					 .title(rs.getString("title"))
					 .content(rs.getString("content"))
					 .wodImage(rs.getString("wodImage"))
					 .createDate(rs.getTimestamp("createDate"))
					 .build();
			  }
			return board;
			
			} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "detail(id) : " + e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		return null;
	}
	
	public List<Board> findAll(int page){ 
		StringBuilder sb = new StringBuilder(); 
		sb.append("SELECT id, ");
		sb.append("userId, title, content, wodImage, readCount, createDate ");
		sb.append("FROM board ");
		sb.append("OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY");
		
		final String SQL = sb.toString();
		List<Board> boards = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, page*3);
			// while 돌려서 rs -> java오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board(
						rs.getInt("id"), 
						rs.getInt("userId"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("wodImage"),
						rs.getInt("readCount"), 
						rs.getTimestamp("createDate")
			     );			
			    boards.add(board);
				
			}
		   return boards;	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findAll(page) : "+ e.getMessage());
		}finally {
			DBConn.close(conn, pstmt,rs);
		}
		return null;
	}
	
	
}
