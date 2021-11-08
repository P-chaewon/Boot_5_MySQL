package com.cw.b5.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cw.b5.member.MemberVO;
import com.cw.b5.product.ProductFilesVO;
import com.cw.b5.product.ProductVO;
import com.cw.b5.util.FileManager;

@Service
@Transactional(rollbackFor = Exception.class)
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private FileManager fileManager;
	
	//회원 리스트 출력
	public List<MemberVO> getMemberList() throws Exception {
		return adminRepository.getMemberList();
	}
	
	//상품 추가
	public int setProductInsert(ProductVO productVO, MultipartFile files) throws Exception {
		int result = adminRepository.setProductInsert(productVO);
		
		if(!files.isEmpty()) {
			ProductFilesVO productFilesVO = new ProductFilesVO();
			productFilesVO.setProduct_num(productVO.getNum());
			String fileName = fileManager.getUseServletContext("/upload/product/", files);
			productFilesVO.setFileName(fileName);
			productFilesVO.setOriName(files.getOriginalFilename());
			result = adminRepository.setProductFilesInsert(productFilesVO);
			
			if(result==0) {
				throw new Exception();
			}
		}
		
		return result;
	}

}
