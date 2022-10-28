package com.rubypaper.board.domain;

import java.util.Date;

import lombok.Data;

@Data
public class JoinVo {
	private String id;
	private String password;
	private String name;
	
	private String ch1;
	private String ch2;
	
	private Role role;
	private String enabled;
	
	private  int  seq;
	private  String  title;
	private  String  writer;
	private  String  content;
	private  Date  createDate ;
	private  int  cnt;	
}
