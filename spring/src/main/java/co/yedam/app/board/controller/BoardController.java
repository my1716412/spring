package co.yedam.app.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.yedam.app.board.BoardDTO;
import co.yedam.app.board.service.impl.BoardDAO;
import co.yedam.app.board.service.impl.BoardService;

@Controller
public class BoardController {
	
	//@Autowired BoardDAO dao;
	@Autowired BoardService boardService;
	
	//목록조회
	@RequestMapping("/boardList")
	public String boardList(HttpServletRequest request, BoardDTO dto) {
		//DAO 목록조회
		List<BoardDTO> list = boardService.selectList(dto);
		
		//request 속성추가
		request.setAttribute("list", list);
		
		//뷰페이지 포워드
		return "board/boardList";
	}
	//게시글등록
	@RequestMapping("/boardInsert")
	public String boardInsert(BoardDTO dto) {
		boardService.Insert(dto);
		return "redirect:boardList";
	}
	//등록폼으로 이동
	@RequestMapping("/boardInsertForm")
	public String boardInsertForm() {
		
		return "board/boardInsertForm";
	}
}
