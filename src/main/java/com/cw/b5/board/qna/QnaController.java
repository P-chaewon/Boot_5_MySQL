package com.cw.b5.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cw.b5.board.BoardVO;
import com.cw.b5.util.Pager;

@Controller
@RequestMapping("qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	@GetMapping("insert")
	public String setInsert() throws Exception {
		return "board/insert";
	}
	
	@PostMapping("insert")
	public String setInsert(BoardVO boardVO, MultipartFile[] files) throws Exception {
		int result = qnaService.setInsert(boardVO, files);
		
		return "redirect:./list";
	}
	
	
	@GetMapping("update")
	public String setUpdate(BoardVO boardVO, Model model) throws Exception {
		boardVO = qnaService.getSelectOne(boardVO);
		model.addAttribute("boardVO", boardVO);
		return "board/update";
	}
	
	@PostMapping("update")
	public String setUpdate(BoardVO boardVO) throws Exception {
		int result = qnaService.setUpdate(boardVO);
		return "redirect:./selectOne?num="+boardVO.getNum();
	}
	
	@GetMapping("delete")
	public String setDelete(BoardVO boardVO) throws Exception {
		int result = qnaService.setDelete(boardVO);
		return "redirect:./list";
	}
	
	@GetMapping("selectOne")
	public ModelAndView getSelectOne(BoardVO boardVO) throws Exception {
		boardVO = qnaService.getSelectOne(boardVO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/select");
		mv.addObject("boardVO", boardVO);
		
		return mv;
	}
	
	@GetMapping("selectList")
	public ModelAndView getSelectList(ModelAndView mv, Pager pager) throws Exception {
		List<BoardVO> ar = qnaService.getSelectList(pager);
		mv.setViewName("board/list");
		mv.addObject("boardList", ar);
		
		return mv;
	}
	

}
