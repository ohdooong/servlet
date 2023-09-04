package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/lesson01/quiz08")

public class GetMethodQuiz08 extends HttpServlet {

	List<String> list = new ArrayList<>(Arrays.asList(
	        "강남역 최고 맛집 소개 합니다.", 
	        "오늘 기분 좋은 일이 있었네요.", 
	        "역시 맛집 데이트가 제일 좋네요.", 
	        "집에 가는 길에 동네 맛집 가서 안주 사갑니다.",
	        "자축 저 오늘 생일 이에요."));
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 한글깨짐방지
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		// Request param
		String input = request.getParameter("input");
		
		//출력
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>검색 결과</title></head><body>");
		
		// input값이 포함된 ArrayList 검사
//		for (int i = 0 ; i < list.size() ; i++) {
//			// 리스트에 있는 i번째 스트링 가져오기
//			String info = list.get(i);
//			
//			// i번째 스트링이 input값을 포함하고있는지 확인
//			if (info.contains(input)) {
//				// 출력			
//				out.print(info.substring(0, info.indexOf(input)) + "<b>" + info.substring(info.indexOf(input),info.indexOf(input) + input.length()) +"</b>" + info.substring(info.indexOf(input)+2) + "<br>");
//			}
//		}
		
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String line = iter.next();
			// 검색
//			if (line.contains(input)) {
//				out.print(line + "<br>");				
//			}
			
			// 보너스 풀이 1) 똑같은 단어가 두개면 문제가 생긴다.
//			if (line.contains(input)) {
//				String[] words = line.split(input);
//				out.print(words[0] +"<b>" + input + "</b>" + words[1] + "<br>");
//			}
			
			// 보너스 풀이 2)
			if (line.contains(input)) {
				line = line.replace(input,"<b>"+input+"</b>" );
				out.print(line + "<br>");
			}
			
		}
		
		out.print("</body></html>");
		
		
		
	}
}
