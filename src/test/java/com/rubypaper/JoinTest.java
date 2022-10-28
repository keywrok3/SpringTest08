package com.rubypaper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.board.domain.JoinVo;
import com.rubypaper.board.persistence.JoinServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JoinTest {

	@Autowired
	private JoinServiceImpl service;
	
	// @Test
	public void select1() {
	}
	
	// @Test
	public void select2() {
		JoinVo vo = new JoinVo();
		vo.setId("member");
		List<JoinVo> li = service.join2(vo);
		for(JoinVo m:li) {
			System.out.println(m.toString());
		}
	}
	
	// @Test
	public void select3() {
		JoinVo vo = new JoinVo();
		vo.setSeq(1007);
	}

	
}
