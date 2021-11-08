package com.cw.b5.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductMapperTest {

	@Autowired
	private ProductMapper productMapper;
	
	@Test
	void getSelectListTest() throws Exception {
		List<ProductVO> ar = productMapper.getSelectList();
		
		assertNotEquals(0, ar.size());
	}

}
