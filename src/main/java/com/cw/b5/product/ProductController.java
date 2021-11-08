package com.cw.b5.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product/**")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("productList")
	public ModelAndView getSelectList() throws Exception {
		ModelAndView mv = new ModelAndView();
		List<ProductVO> list = productService.getSelectList();
		mv.setViewName("product/productList");
		mv.addObject("productList", list);
		
		return mv;
	}

}
