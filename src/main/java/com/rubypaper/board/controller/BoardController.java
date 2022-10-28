package com.rubypaper.board.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rubypaper.board.domain.BoardVo;
import com.rubypaper.board.domain.JoinVo;
import com.rubypaper.board.persistence.BoardServiceImpl;
import com.rubypaper.board.persistence.JoinServiceImpl;

@Controller
@RequestMapping("/board/")
public class BoardController {
	@Autowired
	private BoardServiceImpl boardService;
	
	@Autowired
	private JoinServiceImpl joinService;
	
	@RequestMapping("getBoardList.do")
	public String getBoardList(Model model, JoinVo vo) {
		System.out.println("==>getBoardList 확인!!");
		model.addAttribute("li",joinService.join1(vo));
		return "board/getBoardList";
	}
	
	@RequestMapping("getBoard.do")
	public String getBoard(Model model, JoinVo vo) {
		System.out.println("==>getBoard 확인!!");
		model.addAttribute("m",joinService.join3(vo));
		return "board/getBoard";
	}
	
	@RequestMapping("insertBoard")
	public String insertBoard(Model model, BoardVo vo) {
		return "board/insertBoard";
	}
	
	@RequestMapping("insertBoard.do")
	public String insertBoardOk(Model model, BoardVo vo) {
		vo.setCreateDate(new Date());
		vo.setCnt(3);
		boardService.insert(vo);
		return "redirect:getBoardList.do";
	}
}
