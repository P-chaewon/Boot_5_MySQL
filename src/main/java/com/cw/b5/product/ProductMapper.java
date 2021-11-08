package com.cw.b5.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
	
	//상품 리스트 출력
	public List<ProductVO> getSelectList() throws Exception;

}
