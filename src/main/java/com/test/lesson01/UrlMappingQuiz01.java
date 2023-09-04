package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlMappingQuiz01 extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 한글깨짐방지
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		
		// 출력객체
		PrintWriter out = response.getWriter();
		
		// 날짜
		Date now = new Date();
		
		//formatter
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 d일");
		out.println("오늘의 날짜는 " + sdf.format(now));

	}

}
