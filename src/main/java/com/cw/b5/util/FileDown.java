package com.cw.b5.util;

import java.io.File;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.cw.b5.board.BoardFileVO;

@Component("fileDown")
public class FileDown extends AbstractView {

	@Autowired
	private ServletContext servletContext;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//파일 저장 경로 설정
		
		
	}
}
