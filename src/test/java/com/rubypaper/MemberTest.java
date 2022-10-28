package com.rubypaper;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.board.domain.BoardVo;
import com.rubypaper.board.domain.MemberVo;
import com.rubypaper.board.domain.Role;
import com.rubypaper.board.persistence.BoardServiceImpl;
import com.rubypaper.board.persistence.MemberServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberTest {

	@Autowired
	private MemberServiceImpl service;
	
	@Autowired
	private PasswordEncoder encoder;
	
	//@Before
	public void insert() {
		MemberVo vo = new MemberVo();
		vo.setId("member");
		vo.setName("둘리");
		vo.setPassword("member123");
		vo.setRole(Role.ROLE_MEMBER);
		vo.setEnabled("TRUE");
		service.insert(vo);
	}
	
	//@Test
	public void select() {
		List<MemberVo> li = service.getMemberList(null);
		for(MemberVo m:li) {
			System.out.println(m.toString());
		}
	}
	
	public void updatePw() {
		System.out.println("updatePw!!");
		List<MemberVo> li = service.getMemberList(null);
		for(MemberVo m:li) {
			m.setPassword(encoder.encode(m.getPassword()));
			service.update(m);
			System.out.println(m.toString());
		}
		
	}

	
}
