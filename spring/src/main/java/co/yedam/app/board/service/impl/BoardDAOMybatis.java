package co.yedam.app.board.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.yedam.app.board.BoardDTO;
@Repository
public class BoardDAOMybatis {
	@Autowired
	private SqlSession session;
	
	public int boardCount(BoardDTO dto) {
		return session.selectOne("BoardDAO,boardCount", dto);
	}
	
	public List<BoardDTO>selectList(BoardDTO dto){
		System.out.println("BoardDAOMybatis boardList()");
		return session.selectList("boardDAO.boardList",dto);	
	}
	public int insert(BoardDTO dto) {
		System.out.println("BoardDAOMybatis insertBoard()");
		return session.insert("BoardDAO.insertBoard",dto);
	}
}
