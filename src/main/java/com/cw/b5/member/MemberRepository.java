package com.cw.b5.member;

import org.apache.ibatis.annotations.Mapper;

//@Repository
@Mapper
public interface MemberRepository {
	
	//회원가입
	public int setInsert(MemberVO memberVO) throws Exception;
	
	//회원파일
	public int setFileInsert(MemberFilesVO memberFilesVO) throws Exception;
	
	//로그인
	public MemberVO getSelectOne(MemberVO memberVO) throws Exception;

}
