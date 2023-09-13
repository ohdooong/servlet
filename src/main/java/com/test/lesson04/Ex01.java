package com.test.lesson04;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson04/ex01")

public class Ex01 extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 응답 plain
		response.setContentType("text/plain");
		
		// DB 연결
		MysqlService ms = MysqlService.getInstance();
		ms.connect(); //★★★★★★★★★ 반드시 넣어야 함. (실질적인 DB연결)
		
		// DB Insert
		String insertQuery = "insert into `used_goods`\r\n"
				+ "(`sellerId`,`title`,`description`,`price`)\r\n"
				+ "values\r\n"
				+ "(1, '노트북 팝니다', '새로운 노트북하나 장만해서 팝니다', 250000);";
		try {
			ms.update(insertQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		// DB select 쿼리 수행 & 출력
		PrintWriter out = response.getWriter();
		String query = "select * from `used_goods`";
		try {
			ResultSet res = ms.select(query);
			while (res.next()) { // 결과 행이 있는 동안 계속수행
				out.println(res.getInt("id"));
				out.println(res.getString("title"));
				out.println(res.getInt("price"));
				out.println(res.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		// DB 연결 해제
		ms.disconnect();
	}
}
