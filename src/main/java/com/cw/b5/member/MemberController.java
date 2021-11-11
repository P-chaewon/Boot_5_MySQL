package com.cw.b5.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberJoin")
	public String setInsert(@ModelAttribute MemberVO memberVO) throws Exception {
		return "member/memberJoin";
	}
	
	@PostMapping("memberJoin")
	public String setInsert(@Valid MemberVO memberVO, BindingResult bindingResult,MultipartFile files) throws Exception {
		if(memberService.memberError(memberVO, bindingResult)) {
			return "member/memberJoin";
		}
		int result = memberService.setInsert(memberVO, files);
		
		return "redirect:../";
	}
	
	@GetMapping("memberLogin")
	public String getSelectOne() throws Exception {
		System.out.println("Member Login");
		return "member/memberLogin";
	}
	
//	@PostMapping("memberLogin")
//	public String getSelectOne(MemberVO memberVO, HttpSession session) throws Exception {
//		System.out.println("Member Login Process");
//		memberVO = memberService.getSelectOne(memberVO);
//		if(memberVO!=null) {
//			System.out.println("로그인 성공");
//			session.setAttribute("member", memberVO);
//		}
//		
//		return "redirect:../";
//	}
	
	@GetMapping("memberLogout")
	public String getLogout(HttpSession session) throws Exception {
		
		session.invalidate();
		
		return "redirect:../";
	}

}
