package com.cw.b5.board.notice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cw.b5.board.BoardFileVO;
import com.cw.b5.board.BoardVO;
import com.cw.b5.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	@GetMapping("insert")
	public String setInsert(@ModelAttribute BoardVO boardVO) throws Exception {
		
		return "board/insert";
	}
	
	@PostMapping("insert")
	public String setInsert(@Valid BoardVO boardVO, BindingResult bindingResult,MultipartFile [] files) throws Exception {
		if(bindingResult.hasErrors()) {
			return "board/insert";
		}
		
		int result = noticeService.setInsert(boardVO, files);
		if(result>0) {
			
		}
		
		return "redirect:./selectList";
	}
	
	@GetMapping("update")
	public String setUpdate(BoardVO boardVO, Model model) throws Exception {
		boardVO = noticeService.getSelectOne(boardVO);
		model.addAttribute("boardVO", boardVO);
		
		return "board/update";
	}
	
	@PostMapping("update")
	public String setUpdate(BoardVO boardVO)throws Exception {
		int result = noticeService.setUpdate(boardVO);
		
		return "redirect:./selectOne?num="+boardVO.getNum();
	}
	
	@GetMapping("delete")
	public String setDelete(BoardVO boardVO) throws Exception {
	//	String n = request.getParameter("num");
	//	int num = Integer.parseInt(n);
	//	BoardVO boardVO = new BoardVO();
	//	boardVO.setNum(num);
		int result = noticeService.setDelete(boardVO);
		
		return "redirect:./selectList";
	}
	
	@GetMapping("selectOne")
	public ModelAndView getSelectOne(BoardVO boardVO) throws Exception {
	//	String num = request.getParameter("num");
	//	int n = Integer.parseInt(num);
	//	BoardVO boardVO = new BoardVO();
	//	boardVO.setNum(num);
		ModelAndView mv = new ModelAndView();
		boardVO = noticeService.getSelectOne(boardVO);
	//	파일 가져오기 : 파일만 한 번 더 가져오기 or join
		mv.setViewName("board/select");
		mv.addObject("boardVO", boardVO);
		return mv;
	}
	
	
	@GetMapping("selectList")
	public ModelAndView getSelectList(ModelAndView mv, Pager pager) throws Exception {
		// kind = column
		// search = 검색어
		List<BoardVO> ar = noticeService.getSelectList(pager);
		mv.setViewName("board/list");
		mv.addObject("boardList", ar);
		mv.addObject("pager", pager);
		return mv;
	}
	
	@GetMapping("fileDown")
	public ModelAndView fileDown(BoardFileVO boardFileVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardFileVO = noticeService.fileDown(boardFileVO);
		mv.addObject("fileVO", boardFileVO);
		mv.addObject("path", "/upload/notice/");
		mv.setViewName("fileDown");
		
		return mv;
	}
	

}
