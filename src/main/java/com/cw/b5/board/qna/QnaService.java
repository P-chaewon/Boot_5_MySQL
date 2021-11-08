package com.cw.b5.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cw.b5.board.BoardFileVO;
import com.cw.b5.board.BoardService;
import com.cw.b5.board.BoardVO;
import com.cw.b5.util.Pager;

@Service
public class QnaService implements BoardService{

	@Autowired
	private QnaMapper qnaMapper;
	
	@Override
	public int setInsert(BoardVO boardVO, MultipartFile[] files) throws Exception {
		return qnaMapper.setInsert(boardVO);
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		return qnaMapper.setUpdate(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return qnaMapper.setDelete(boardVO);
	}

	@Override
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception {
		return qnaMapper.getSelectOne(boardVO);
	}

	@Override
	public List<BoardVO> getSelectList(Pager pager) throws Exception {
		return qnaMapper.getSelectList(pager);
	}

	@Override
	public BoardFileVO fileDown(BoardFileVO boardFileVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
