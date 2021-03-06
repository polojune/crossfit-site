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
    
	
	
	public int count(String keyword) {
		final String SQL = "SELECT count(*) FROM board WHERE title LIKE ? OR content LIKE ?";

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"count(keyword) : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return -1;
	}
	
	
	
	public List<Board> findAll(int page, String keyword) {
		StringBuilder sb = new StringBuilder();
		//sb.append("SELECT /*+ INDEX_DESC(BOARD SYS_C007932)*/id,");
		sb.append("SELECT id, ");
		sb.append("userId, title, content, wodImage, readCount, createDate ");
		sb.append("FROM board ");
		sb.append("WHERE title like ? OR content like ? ");
		sb.append("OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY");

		final String SQL = sb.toString();
		List<Board> boards = new ArrayList<>();

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			pstmt.setInt(3, page*3);
			// while 돌려서 rs -> java오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			while(rs.next()) {
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
			System.out.println(TAG+"findAll(page,keyword) : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return null;
	}
	
	
	public int deleteById(int id) {
		System.out.println("BoardRepository : id : "+id);
		final String SQL = "DELETE FROM board WHERE id = ?";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "deleteById : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);

		}
		return -1;
	}
   
	
	public int count() {
		final String SQL = "SELECT count(*) FROM board";

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"count : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return -1;
	}
	
	
	public int update(Board board) {
		final String SQL = "UPDATE board SET title = ?, wodImage = ?, content = ? WHERE id = ?";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getWodImage());
            pstmt.setString(3, board.getContent());
            pstmt.setInt(4, board.getId());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "update : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);

		}
		return -1;
	}
	
public Board findById(int id) {
		
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
			System.out.println(TAG + "findById(id) : " + e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		return null;
	}
	
	
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
		//sb.append("SELECT /*+ INDEX_DESC(BOARD SYS_C007932)*/id,");
		sb.append("SELECT id, ");
		sb.append("userId, title, content, wodImage, readCount, createDate ");
		sb.append("FROM board ORDER BY createDate DESC ");
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
