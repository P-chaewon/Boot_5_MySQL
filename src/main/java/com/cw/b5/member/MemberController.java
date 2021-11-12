package com.cw.b5.member;

import java.security.Principal;
import java.util.Enumeration;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
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
	
	@GetMapping("usePrincipal")
	public void usePrincipal(@AuthenticationPrincipal MemberVO memberVO) {
		System.out.println(memberVO);
	}
	
	@GetMapping("useSession")
	public void useSession(HttpSession session) {
		Enumeration<String> en = session.getAttributeNames();
		while (en.hasMoreElements()) {
			String string = (String)en.nextElement();			
			System.out.println(string);
		}
		Object object = session.getAttribute("SPRING_SECURITY_CONTEXT");
		System.out.println(object);
		SecurityContextImpl sc = (SecurityContextImpl)object;
		Authentication authentication = sc.getAuthentication();
		MemberVO memberVO = (MemberVO)authentication.getPrincipal();
		
		System.out.println(memberVO);
	}
	
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
	
//	@GetMapping("memberLogout")
//	public String getLogout(HttpSession session) throws Exception {
//		System.out.println("Log out-----------");
//		
//		session.invalidate();
//		
//		return "redirect:../";
//	}

}
