package com.test.lesson04;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson04/delete-site")

public class DeleteBookMark extends HttpServlet{
	
	@Override
	public void doGet (HttpServletRequest request ,HttpServletResponse response) throws IOException {
		
		// request param
		int id = Integer.valueOf(request.getParameter("id"));
		
		// db 연결
		MysqlService ms = MysqlService.getInstance();
		ms.connect();
		
		// delete query
		String deleteQuery = "delete from `bookmark` where `id` = " + id + ";";
		
		try {
			ms.update(deleteQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// db 해제
		ms.disconnect();
		
		//redirect
		response.sendRedirect("/lesson04/quiz02/bookMark.jsp");
	}
	
}
