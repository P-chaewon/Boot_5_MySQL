package com.cw.b5.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cw.b5.board.BoardVO;
import com.cw.b5.util.Pager;

@SpringBootTest
class NoticeMapperTest {

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Test
	void setInsertTest() throws Exception{
		for(int i=0;i<100;i++) {
			BoardVO boardVO = new BoardVO();
			boardVO.setTitle("notice_title10"+i);
			boardVO.setContents("notice_contents10"+i);
			boardVO.setWriter("notice_writer10"+i);
			
			int result = noticeMapper.setInsert(boardVO);
			
			if(i%10==0) {
				Thread.sleep(500);
			}
		}
		
		System.out.println("finish");
//		assertNotEquals(0, result);
	}
	
//	@Test
	void setUpdateTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(7);
		boardVO.setTitle("title2");
		boardVO.setContents("contents2");
		
		int result = noticeMapper.setUpdate(boardVO);
		assertNotEquals(0, result);
	}
	
//	@Test
	void setHitUpdateTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(1);
		int result = noticeMapper.setHitUpdate(boardVO);
		
		assertNotEquals(0, result);
	}
	
//	@Test
	void setDelete() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(7);
		
		int result = noticeMapper.setDelete(boardVO);
		
		assertNotEquals(0, result);
	}
	
//	@Test
	void getSelectOne() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(1);
		System.out.println(boardVO.hashCode());
		boardVO = noticeMapper.getSelectOne(boardVO);
		System.out.println(boardVO.hashCode());
		
		assertNotNull(boardVO);
		
	}
	
//	@Test
	void getSelectList() throws Exception {
		Pager pager = new Pager();
		List<BoardVO> ar = noticeMapper.getSelectList(pager);
		assertNotEquals(0, ar.size());
	}

}
