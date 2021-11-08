package com.cw.b5.util;

import lombok.Data;

@Data
public class Pager {
	
	private String kind;
	private String search;
	
	//pagination
	//한 페이지에 보이는 게시물 개수
	private Integer perPage;
	//현재 페이지 번호
	private Integer pn;
	//현재 페이지에 있는 게시물의 시작 번호
	private Integer startRow;
	
	private Long startNum;
	private Long lastNum;
	
	private boolean lastCheck; // true면 마지막 블럭, false면 마지막 블럭이 아님
	private boolean startCheck; // true면 첫번째 블럭, false면 첫번째 블럭 아님
	
	public void makeRow() {
		this.startRow = (this.getPn()-1)*this.getPerPage();
	}
	
	public void makeNum(Long totalCount) {
		//전체 페이지 개수 구하기
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount/this.getPerPage()!=0) {
			totalPage++;
		}
		//총 블럭의 개수 구하기
		Long perBlock=5L;
		Long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock!=0) {
			totalBlock++;
		}
		//pn으로 현재 블럭번호 구하기
		//pn = 1 curBlock = 1
		//pn = 5 curBlock = 1
		//pn = 6 curBlock = 2
		Long curBlock = this.getPn()/perBlock;
		if(this.getPn()%perBlock!=0) {
			curBlock++;
		}
		
		//curBlock으로 시작번호 끝번호 구하기
		//curBlock 1  startNum 1  lastNum 5
		//curBlock 2  startNum 6  lastNum 10
		this.startNum = (curBlock-1)*perBlock+1;
		this.lastNum = curBlock*perBlock;
		
		if(curBlock == 1) {
			this.startCheck = true;
		}
		
		if(curBlock == totalBlock) {
			this.lastCheck=true;
			this.lastNum = totalPage;
		}
		
		System.out.println("시작번호 : "+this.startNum);
		System.out.println("끝번호 : "+this.lastNum);
	}
	
	
	//setter, getter
	
	public Integer getPn() {
		if(this.pn == null || this.pn<=0) {
			this.pn=1;
		}
		return this.pn;
	}
	
	public Integer getPerPage() {
		if(this.perPage == null || this.perPage<1) {
			this.perPage =10;
		}
		return this.perPage;
	}
	
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return this.search;
	}

}
