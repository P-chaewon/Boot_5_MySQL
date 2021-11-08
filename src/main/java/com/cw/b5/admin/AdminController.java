package com.cw.b5.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cw.b5.member.MemberVO;
import com.cw.b5.product.ProductVO;

@Controller
@RequestMapping("/admin/**")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("memberList")
	public ModelAndView getMemberList() throws Exception {
		ModelAndView mv = new ModelAndView();
		List<MemberVO> list = adminService.getMemberList();
		mv.addObject("memberList", list);
		mv.setViewName("admin/memberList");
		
		return mv;		
	}
	
	@GetMapping("productInsert")
	public String setProductInsert() throws Exception {
		return "admin/productInsert";
	}
	
	@PostMapping("productInsert")
	public String setProductInsert(ProductVO productVO, MultipartFile files) throws Exception {
		int result = adminService.setProductInsert(productVO, files);
		
		return "redirect:../product/productList";
	}

}
