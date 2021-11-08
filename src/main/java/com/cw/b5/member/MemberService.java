package com.cw.b5.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cw.b5.util.FileManager;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private FileManager fileManager;
	
	public int setInsert(MemberVO memberVO, MultipartFile files) throws Exception {
		int result = memberRepository.setInsert(memberVO);
		
		if(!files.isEmpty()) {			
			MemberFilesVO memberFilesVO = new MemberFilesVO();
			memberFilesVO.setMember_id(memberVO.getId());
			String fileName = fileManager.getUseServletContext("/upload/member/", files);
			memberFilesVO.setFileName(fileName);
			memberFilesVO.setOriName(files.getOriginalFilename());
			result = memberRepository.setFileInsert(memberFilesVO);
			if(result==0) { //insert가 되지 않았다면
				throw new Exception(); //예외 강제 발생
			}
		}
		
		return result;
	}
	
	public MemberVO getSelectOne(MemberVO memberVO) throws Exception {
		return memberRepository.getSelectOne(memberVO);
	}

}
