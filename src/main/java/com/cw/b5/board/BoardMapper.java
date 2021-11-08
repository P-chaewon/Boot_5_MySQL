package com.cw.b5.board;

import java.util.List;

import com.cw.b5.util.Pager;

public interface BoardMapper {
	
	//Insert 글쓰기
	public int setInsert(BoardVO boardVO) throws Exception;
	
	//Insert 파일 저장
	public int setFileInsert(BoardFileVO boardFileVO) throws Exception;
	
	//Update 글수정
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	//Update 조회수 수정
	public int setHitUpdate(BoardVO boardVO) throws Exception;
	
	//Delete 글삭제
	public int setDelete (BoardVO boardVO) throws Exception;
	
	//Select 글 하나 조회
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception;
	
	//Select 글 리스트 조회
	public List<BoardVO> getSelectList(Pager pager) throws Exception;
	
	//Select 게시물 수 조회
	public Long getTotalCount(Pager pager) throws Exception;
	
	//Select 파일 조회
	public BoardFileVO fileDown(BoardFileVO boardFileVO) throws Exception;
	

}
