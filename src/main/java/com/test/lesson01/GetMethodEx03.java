package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/ex03")

public class GetMethodEx03 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 한글 깨짐 방지
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/plain");
		
		// 한글 깨짐 방지 => json string
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json");
		
		// Request Parameter => user_id
		String userId = request.getParameter("user_id");
		String name = request.getParameter("name");
		int age = Integer.valueOf(request.getParameter("age")); // 받아온값이 null이고, 그것을 Integer로 형변환 하려고하면 에러가 난다. 
		
		
		// 출력
		PrintWriter out = response.getWriter();
//		out.println("user_id : " + userId);
//		out.println("name:"+name);
//		out.println("age:"+age);
		
		// JSON 출력
		// {"user_id":"ohseung1486","name":"오승환", "age":30}
		
		out.print("{\"user_id\":\""+ userId +"\", \"name\":\"" + name + "\", \"age\":" + age +"}"); // 큰 따옴표 안에 큰 따옴표 쓰러면 \"를 이용
		
	}
	
	
}
