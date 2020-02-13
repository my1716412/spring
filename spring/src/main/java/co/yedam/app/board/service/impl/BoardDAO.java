package co.yedam.app.board.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import co.yedam.app.board.BoardDTO;

@Component
public class BoardDAO {
	protected Connection conn;
	protected PreparedStatement psmt;
	protected ResultSet rs;
	protected DataSource ds;  //컨넥션 POOL 사용을 위한 데이터연결 생성 객체
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe"; //예담학원용
	//private String url="jdbc:oracle:thin:@localhost:1521:orcl"; //집용
	private String user="hr";
	private String password="hr";

	//추가
	public int insert(BoardDTO dto) {
		int r = 0;
		//디비연결
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try { 
			String sql = "insert into board(no, poster, subject, contents, lastpost, views)"
					+" values((select nvl(max(no),0)+1 from board ),?,?,?,sysdate,1)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getPoster());
			psmt.setString(2, dto.getSubject());
			psmt.setString(3, dto.getContents());
			r = psmt.executeUpdate();
		 } catch (Exception e) {
			e.printStackTrace();
		} 
		return r;
	}
//수정
	public int Update(BoardDTO dto) {
		int r = 0;
		try { 
			String sql = "Update board set subject=?, contents=?"
					+"where no = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(3, dto.getNo());
			psmt.setString(1, dto.getSubject());
			psmt.setString(2, dto.getContents());
			r = psmt.executeUpdate();
		 } catch (Exception e) {
			e.printStackTrace();
		} 
		return r;
	}

//삭제
	public int delete(BoardDTO dto) {
		int r = 0;
		try { 
			String sql = "delete board "
					+"where no = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getNo());
			r = psmt.executeUpdate();
		 } catch (Exception e) {
			e.printStackTrace();
		} 
		return r;
	}
//단건조회
	public BoardDTO selectOne(int no) {
		BoardDTO dto = new BoardDTO();
		
		try {
			String sql = "select * from board where no=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,no);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setNo(rs.getInt("no"));
			//	dto.setLastpost(rs.getDate("Lastpost"));
				dto.setContents(rs.getString("Contents"));
				dto.setPoster(rs.getString("Poster"));
				dto.setViews(rs.getInt("views"));
				dto.setSubject(rs.getString("Subject"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return dto;
	}
//목록
	public List<BoardDTO> selectList() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		// 1.DB연결
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 2.쿼리실행
		try {
			String sql = "select * from board order by no desc";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(sql);
			// 3.결과저장
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setLastpost(rs.getDate("Lastpost"));
				dto.setContents(rs.getString("Contents"));
				dto.setPoster(rs.getString("Poster"));
				dto.setViews(rs.getInt("views"));
				dto.setSubject(rs.getString("Subject"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
}
