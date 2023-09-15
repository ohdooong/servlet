package com.test.lesson04;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson04/delete-user")

public class DeleteUserServlet extends HttpServlet {

	@Override
	
	// userList에서 <a>로 오기 때문에 get
	// db에서 user 삭제
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		// 응답 생략
		
		// request parameter
		int id = Integer.valueOf(request.getParameter("id"));
		
		// DB 연결
		MysqlService ms = MysqlService.getInstance();
		ms.connect();
		
		// delete query
		String deleteQuery = "delete from `new_user` where `id` = " + id + ";";
		try {
			ms.update(deleteQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// DB 연결해제
		ms.disconnect();
		
		// redirect => userList.jsp
		response.sendRedirect("/lesson04/ex02/userList.jsp");
	}

}
