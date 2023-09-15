package com.test.lesson04;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson04/add-bookmark")

public class AddBookMarkServlet extends HttpServlet {
	
	@Override
	public void doGet (HttpServletRequest request,HttpServletResponse response) throws IOException {
		// 응답x
		
		// request parameter
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		
		// db연결
		MysqlService ms = MysqlService.getInstance();
		ms.connect();
		
		// insert query
		String insertQuery = "insert into `bookmark` (`name`,`url`) values ('" + name +  "','" + url +"')";
		try {
			ms.update(insertQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// db 해제
		ms.disconnect();
		
		// redirect
		response.sendRedirect("/lesson04/quiz02/bookMark.jsp");
	}
	
	
}
