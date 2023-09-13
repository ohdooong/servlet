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

@WebServlet("/lesson04/quiz01")

public class Quiz01 extends HttpServlet{
	
	public void doGet (HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		// response -> plain
		response.setContentType("text/plain");
		
		// DB 연결
		MysqlService ms = MysqlService.getInstance();
		ms.connect();
		
		// DB 인서트 쿼리 수행
		String insertQuery = "insert into \r\n"
				+ "(`realtorId`,`address`,`area`,`type`,`price`)\r\n"
				+ "values\r\n"
				+ "(3,'헤라펠리스 101동 5305호',350,'매매',1500000);";
		try {
			ms.update(insertQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		// DB SELECT 쿼리 수행
		PrintWriter out = response.getWriter();
		
		String selectQuery = "select `address`,`area`,`type` from `real_estate` order by `id` desc limit 10;";
		
		try {
			ResultSet res = ms.select(selectQuery);
			while (res.next()) {
				out.println("매물 주소: " + res.getString("address") + ", 면적: " + res.getInt("area") + ", 타입: " + res.getString("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// DB 종료
	}
	
	
	
}
