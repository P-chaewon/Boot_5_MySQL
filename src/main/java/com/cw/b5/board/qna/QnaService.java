package com.cw.b5.board.qna;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cw.b5.board.BoardFileVO;
import com.cw.b5.board.BoardService;
import com.cw.b5.board.BoardVO;
import com.cw.b5.util.FileManager;
import com.cw.b5.util.Pager;

@Service
public class QnaService implements BoardService{

	@Autowired
	private QnaRepository qnaRepository;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public int setInsert(BoardVO boardVO, MultipartFile[] files) throws Exception {
		int result = qnaRepository.setInsert(boardVO);
		
		result = qnaRepository.setRefUpdate(boardVO);
		for(MultipartFile multipartFile:files) {
			//multipartFile.isEmpty()
			if(multipartFile.getSize()==0L) {
				continue;
			}
			
			BoardFileVO boardFileVO = new BoardFileVO();
			boardFileVO.setNum(boardVO.getNum());
			String fileName = fileManager.getUseServletContext("/upload/notice/", multipartFile);
			boardFileVO.setFileName(fileName);
			boardFileVO.setOriName(multipartFile.getOriginalFilename());
			
			result = qnaRepository.setFileInsert(boardFileVO);
		}
		
		return result; //noticeMapper.setInsert(boardVO);
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		return qnaRepository.setUpdate(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return qnaRepository.setDelete(boardVO);
	}

	@Override
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception {
		return qnaRepository.getSelectOne(boardVO);
	}

	@Override
	public List<BoardVO> getSelectList(Pager pager) throws Exception {
		pager.makeRow();
		
		
		//1. 총글의 갯수-DB에서 조회 
		Long totalCount = qnaRepository.getTotalCount(pager);
		System.out.println("총글의 갯수 : "+totalCount);
		pager.makeNum(totalCount);
		
		
		return qnaRepository.getSelectList(pager);
	}

	@Override
	public BoardFileVO fileDown(BoardFileVO boardFileVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int setReplyInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {
		int result = qnaRepository.setReplyUpdate(boardVO);
		result = qnaRepository.setReplyInsert(boardVO);
		
		//파일 저장 코드 작성
		
		return 0;
	}
	
	

}
