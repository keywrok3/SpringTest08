package com.rubypaper.board.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubypaper.board.domain.BoardVo;
import com.rubypaper.board.domain.JoinVo;
import com.rubypaper.board.domain.MemberVo;
import com.rubypaper.board.persistence.BoardServiceImpl;
import com.rubypaper.board.persistence.JoinServiceImpl;
import com.rubypaper.board.persistence.MemberServiceImpl;

@Controller
@RequestMapping("/board/")
public class MemberController {
	@Autowired
	private MemberServiceImpl memberService;
	
	@Autowired
	private JoinServiceImpl joinService;
	
	@Autowired
	private BoardServiceImpl boardService;
	
	@RequestMapping("getMemberList.do")
	public String getBoardList(Model model, MemberVo vo) {
		System.out.println("==>getMemberList 확인!!");
		model.addAttribute("li",memberService.getMemberList(vo));
		return "board/getMemberList";
	}
	
	@RequestMapping("deleteMember.do")
	public String deleteMember(Model model, MemberVo vo, JoinVo j_vo) {
		System.out.println("==>deleteMember 확인!!");
		j_vo.setId(vo.getId());
		List<JoinVo> li = joinService.join2(j_vo);
		for(JoinVo m : li) {
			BoardVo b_vo = new BoardVo();
			b_vo.setSeq(m.getSeq());
			boardService.delete(b_vo);
		}
		memberService.delete(vo);
		return "redirect:getMemberList.do";
	}
}
