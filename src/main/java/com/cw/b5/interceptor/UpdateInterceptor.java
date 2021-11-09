package com.cw.b5.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cw.b5.board.BoardVO;
import com.cw.b5.member.MemberVO;

@Component
public class UpdateInterceptor implements HandlerInterceptor {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//로그인 유저
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		//작성자
		Map<String, Object> model = modelAndView.getModel();
		BoardVO boardVO = (BoardVO)model.get("boardVO");
		if(boardVO == null) {
			return ; //return을 만나면 그 즉시 메서드 종료
		}
		if(!memberVO.getId().equals(boardVO.getWriter())) {
			modelAndView.addObject("msg", "작성자만 수정 가능");
			modelAndView.addObject("path", "./selectList");
			modelAndView.setViewName("common/result");
		}
		
	}
	
	

}
