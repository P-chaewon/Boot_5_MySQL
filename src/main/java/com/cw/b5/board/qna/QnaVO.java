package com.cw.b5.board.qna;

import com.cw.b5.board.BoardVO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//@Data만 사용하면 Hashcode 메서드 충돌 가능성 있음 
//@EqualsAndHashCode(callSuper=false) 같이 사용해야 충돌 가능성 없음
//@Data
//@EqualsAndHashCode(callSuper=false)
//아니면 
@Getter
@Setter
//사용하면 됨
public class QnaVO extends BoardVO{
	
	private Integer ref;
	private Integer step;
	private Integer depth;

}
