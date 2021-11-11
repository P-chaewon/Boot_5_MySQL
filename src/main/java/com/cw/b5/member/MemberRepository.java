package com.cw.b5.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {

	public int setInsert(MemberVO memberVO) throws Exception;
	
	public int setFileInsert(MemberFilesVO memberfilesVO) throws Exception;
	
	public MemberVO getSelectOne(MemberVO memberVO) throws Exception;
	
	public List<MemberVO> getSelectList() throws Exception;
}
