package com.cw.b5.admin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cw.b5.member.MemberVO;
import com.cw.b5.product.ProductVO;

@SpringBootTest
class AdminMapperTest {
	
	@Autowired
	private AdminRepository adminRepository;

//	@Test
	void getMemberListTest() throws Exception{
		List<MemberVO> ar = adminRepository.getMemberList();
		for(MemberVO memberVO : ar) {
			System.out.println(memberVO.getId());
			System.out.println(memberVO.getName());
			System.out.println(memberVO.getEmail());
			System.out.println(memberVO.getMemberFilesVO().getFileName());
		}
		
		assertNotEquals(0, ar.size());
	}
	
	@Test
	void setProductInsertTest() throws Exception {
		ProductVO productVO = new ProductVO();
		productVO.setName("삼겹살");
		productVO.setPrice(9000);
		productVO.setInformation("맛있는 삼겹살");
		
		int result = adminRepository.setProductInsert(productVO);
		assertNotEquals(0, result);
	}

}
