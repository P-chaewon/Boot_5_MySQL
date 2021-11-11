package com.cw.b5.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class MemberMapperTest {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
//	@Test
	void setInsertTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("test_id2");
		memberVO.setPw("test_pw2");
		memberVO.setName("test_name2");
		memberVO.setEmail("testmail2@naver.com");
		int result = memberRepository.setInsert(memberVO);
		
		assertNotEquals(0, result);
	}
	
//	@Test
	void setFileInsertTest() throws Exception {
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setMember_id("test_id2");
		memberFilesVO.setFileName("test_fileName");
		memberFilesVO.setOriName("test_oriName");
		
		int result = memberRepository.setFileInsert(memberFilesVO);
		
		assertNotEquals(0, result);
	}
	
	@Test
	void getSelectOneTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("test_id1");
		memberVO.setPw("test_pw1");
		memberVO = memberRepository.getSelectOne(memberVO);
		
		assertNotNull(memberVO);
	}
}
