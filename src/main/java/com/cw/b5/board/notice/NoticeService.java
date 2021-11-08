package com.cw.b5.board.notice;

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
public class NoticeService implements BoardService{
	
	//ID IOC
	@Autowired
	private NoticeMapper noticeMapper;

	@Autowired
	private FileManager fileManager;
	
	@Override
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {
		// TODO Auto-generated method stub
//		fileManager.getUseResourceLoader("upload/notice/", files[0]);
//		fileManager.getUseClassPathResource("upload/notice/", files[0]);
		int result = noticeMapper.setInsert(boardVO);
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
			
			result = noticeMapper.setFileInsert(boardFileVO);
		}
		
		return result; //noticeMapper.setInsert(boardVO);
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.setUpdate(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.setDelete(boardVO);
	}

	@Override
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		
		return noticeMapper.getSelectOne(boardVO);
	}

	@Override
	public List<BoardVO> getSelectList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		Long totalCount = noticeMapper.getTotalCount(pager);
		pager.makeRow();
		pager.makeNum(totalCount);
		System.out.println("게시물 개수 : "+totalCount);
		return noticeMapper.getSelectList(pager);
	}

	@Override
	public BoardFileVO fileDown(BoardFileVO boardFileVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.fileDown(boardFileVO);
	}
	
	

	
}
