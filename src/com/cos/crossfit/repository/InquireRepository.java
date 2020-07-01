package com.cos.crossfit.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.crossfit.db.DBConn;
import com.cos.crossfit.dto.InquireResponseDto;
import com.cos.crossfit.model.Board;
import com.cos.crossfit.model.Inquire;
import com.cos.crossfit.model.Users;

public class InquireRepository {
	private static final String TAG = "BoardRepository : ";
	private static InquireRepository instance = new InquireRepository();

	public InquireRepository() {
	}

	public static InquireRepository getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	

	public InquireResponseDto importPost(int id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT i.id , i.userId, i.title,i.content,i.readCount,i.createDate,u.username ");
		sb.append("FROM inquire i INNER JOIN users u ");
		sb.append("ON i.userId = u.id ");
		sb.append("WHERE i.id = ?");  
		
		final String SQL = sb.toString();
		InquireResponseDto inquireDto = null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				inquireDto = new InquireResponseDto();
				Inquire inquire = Inquire.builder()
						.id(rs.getInt("id"))
						.userId(rs.getInt("userId"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.readCount(rs.getInt("readCount"))
						.createDate(rs.getTimestamp("createDate"))
						.build();
				inquireDto.setInquire(inquire);
				inquireDto.setUsername(rs.getString("username"));
				
			}
			//System.out.println("inquireDto: " + inquireDto.getUsername());
			return inquireDto;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "inquireDto(id) : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt,rs);
		}
		return null;
	}
	
	public List<InquireResponseDto> listAll() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT i.id, i.userId, i.title, i.content, i.readCount,i.createDate,u.username ");
		sb.append("FROM inquire i INNER JOIN users u ");
		sb.append("ON i.userid = u.id ");
	    sb.append("ORDER BY createDate DESC");
		final String SQL = sb.toString();
		InquireResponseDto inquireDto = null;
		
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			List<InquireResponseDto> posts = new ArrayList<>();

			while (rs.next()) {
			  inquireDto = new InquireResponseDto(); 
			  Inquire inquire = Inquire.builder()
					  .id(rs.getInt(1))
					  .userId(rs.getInt(2))
					  .title(rs.getString(3))
					  .content(rs.getString(4))
					  .readCount(rs.getInt(5))
					  .createDate(rs.getTimestamp(6))
					  .build();
		        inquireDto.setInquire(inquire);
		        inquireDto.setUsername(rs.getString(7));
		        System.out.println("inquireDto :" + inquireDto);
		        
		        posts.add(inquireDto);
			}
			//System.out.println("posts:" + posts);
			return posts;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}

	
	public int save(Inquire inquire) {
		try {
			String sql = "INSERT INTO inquire(id,userId,title,content,readCount,createDate) VALUES(inquire_seq.nextval, ?,?,?,?, sysdate)";
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, inquire.getUserId());
			pstmt.setString(2, inquire.getTitle());
			pstmt.setString(3, inquire.getContent());
			pstmt.setInt(4, inquire.getReadCount());

			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "save : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);

		}
		return -1;
	}

	public List<Inquire> list() {
		try {
			String sql = "SELECT * FROM inquire ORDER BY id DESC";
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Inquire> posts = new ArrayList<>();

			while (rs.next()) {
				Inquire post = new Inquire();
				post.setId(rs.getInt("id"));
				post.setUserId(rs.getInt("userId"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setReadCount(rs.getInt("readCount"));
				post.setCreateDate(rs.getTimestamp("createDate"));
				posts.add(post);
			}
			System.out.println("posts:" + posts);
			return posts;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}

	public int count(String keyword) {
		final String SQL = "SELECT count(*) FROM board WHERE title LIKE ? OR content LIKE ?";

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "count(keyword) : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return -1;
	}

	public List<Board> findAll(int page, String keyword) {
		StringBuilder sb = new StringBuilder();
		// sb.append("SELECT /*+ INDEX_DESC(BOARD SYS_C007932)*/id,");
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
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setInt(3, page * 3);
			// while 돌려서 rs -> java오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board(rs.getInt("id"), rs.getInt("userId"), rs.getString("title"),
						rs.getString("content"), rs.getString("wodImage"), rs.getInt("readCount"),
						rs.getTimestamp("createDate"));
				boards.add(board);
			}

			return boards;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findAll(page,keyword) : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return null;
	}

	public int deleteById(int id) {
		//System.out.println("InquireRepository : id : " + id);
		final String SQL = "DELETE FROM inquire WHERE id = ?";
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
			if (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "count : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return -1;
	}

	public int update(Inquire inquire) {
		 System.out.println("Inquire:update" + inquire);
		final String SQL = "UPDATE inquire SET  title = ?, content = ?  WHERE id = ?";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			
			pstmt.setString(1, inquire.getTitle());
			pstmt.setString(2, inquire.getContent());
			pstmt.setInt(3, inquire.getId());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "update : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);

		}
		return -1;
	}

//	public Inquire importPost(int id) {
//	
//		try {
//			String SQL  ="SELECT * FROM inquire WHERE id=? ";
//			conn = DBConn.getConnection();
//			pstmt = conn.prepareStatement(SQL);
//			// 물음표 완성하기
//			pstmt.setInt(1, id);
//
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				
//				Inquire inquire = Inquire.builder()
//						.id(rs.getInt(1))
//						.userId(rs.getInt(2))
//						.title(rs.getString(3))
//						.content(rs.getString(4))
//						.readCount(rs.getInt(5))
//						.createDate(rs.getTimestamp(6))
//						.build();
//				
//              return inquire;
//			}
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(TAG + "importPost : " + e.getMessage());
//		} finally {
//			DBConn.close(conn, pstmt, rs);
//		}
//		return null;
//	}

	public InquireResponseDto detail(int id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT i.id , i.userId, i.title,i.content,i.readCount,i.createDate,u.username ");
		sb.append("FROM inquire i INNER JOIN users u ");
		sb.append("ON i.userId = u.id ");
		sb.append("WHERE i.id = ?");  
		
		final String SQL = sb.toString();
		InquireResponseDto inquireDto = null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				inquireDto = new InquireResponseDto();
				Inquire inquire = Inquire.builder()
						.id(rs.getInt("id"))
						.userId(rs.getInt("userId"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.readCount(rs.getInt("readCount"))
						.createDate(rs.getTimestamp("createDate"))
						.build();
				inquireDto.setInquire(inquire);
				inquireDto.setUsername(rs.getString("username"));
				
			}
			System.out.println("inquireDto: " + inquireDto.getUsername());
			return inquireDto;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "detail(id) : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt,rs);
		}
		return null;
	}

}
