package co.yedam.app.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.app.board.BoardDTO;
import co.yedam.app.common.LogAdvice;

@Service
public class BoardService {
	@Autowired BoardDAOMybatis dao;
	//목록조회
	public List<BoardDTO> selectList(BoardDTO dto) {
		//권한체크
		//트랜잭션처리
		//페이징처리
		int p = dto.getPage();
		int pageunit = 3;
		int start = (p-1) * pageunit +1; 
		int end = start + pageunit -1;
		dto.setStart(start);
		dto.setEnd(end);
		
		//전체 페이지 수
		int totalRecord = dao.boardCount(dto);
		int lastPage = totalRecord / pageunit + ((totalRecord % pageunit > 0) ? 1 : 0); 
		dto.setLastPage(lastPage);
		return dao.selectList(dto);
	}
	//등록
	public int Insert(BoardDTO dto) {
		//권한체크
		//트랜잭션처리
		//로그기록
		return dao.insert(dto);
	}
	//등록
	public int insert(BoardDTO dto) {
		return dao.insert(dto);
	}
}
