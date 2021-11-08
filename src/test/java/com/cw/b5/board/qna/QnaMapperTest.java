package com.cw.b5.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cw.b5.board.BoardVO;

@SpringBootTest
class QnaMapperTest {

	@Autowired
	private QnaMapper qnaMapper;
	
//	@Test
	void setInsertTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("qna_title3");
		boardVO.setContents("qna_contents3");
		boardVO.setWriter("qna_writer3");
		
		int result = qnaMapper.setInsert(boardVO);
		
		assertNotEquals(0, result);
	}
	
	@Test
	void setUpdateTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("update_title");
		boardVO.setNum(2);
		boardVO.setContents("update_contents");
		int result = qnaMapper.setUpdate(boardVO);
		
		assertNotEquals(0, result);
	}
	
//	@Test
	void setHitUpdate() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(1);
		int result = qnaMapper.setHitUpdate(boardVO);
		
		assertNotEquals(0, result);
	}

}
