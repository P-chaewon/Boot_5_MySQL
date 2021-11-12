package com.cw.b5.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {

	public int setInsert(MemberVO memberVO) throws Exception;
	
	public int setFileInsert(MemberFilesVO memberfilesVO) throws Exception;
	
	public MemberVO getSelectOne(String username) throws Exception;
	
	public List<MemberVO> getSelectList() throws Exception;
	
	//member role insert
	public int setMemberRoleInsert(Map<String, Object> map) throws Exception;
}
