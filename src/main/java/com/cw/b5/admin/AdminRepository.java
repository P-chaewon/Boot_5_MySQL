package com.cw.b5.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cw.b5.member.MemberVO;
import com.cw.b5.product.ProductFilesVO;
import com.cw.b5.product.ProductVO;

@Mapper
public interface AdminRepository {
	
	//사용자 리스트 출력
	public List<MemberVO> getMemberList() throws Exception;
	
	//상품 추가
	public int setProductInsert(ProductVO productVO) throws Exception;
	
	//상품 이미지 추가
	public int setProductFilesInsert(ProductFilesVO productFilesVO) throws Exception;

}
