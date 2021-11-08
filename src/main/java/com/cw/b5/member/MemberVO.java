package com.cw.b5.member;

import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private MemberFilesVO memberFilesVO;

}
