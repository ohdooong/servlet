<%@page import="java.sql.ResultSet"%>
<%@page import="com.test.common.MysqlService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// DB 연결
	MysqlService ms = MysqlService.getInstance();
	ms.connect();
	
	// select query 실행
	String selectQuery = "select B.`pictureUrl`, B.`title`, B.`price`, A.`id`, A.`nickname` from `seller` as A join `used_goods` as B on A.`id` = B.`sellerId` order by A.`id` desc;";
	ResultSet res = ms.select(selectQuery);
%>
<div class="d-flex flex-wrap justify-content-start">
	
<%	
	// 반복
	while (res.next()) {
			String picture = res.getString("pictureUrl");

		if (res.getString("pictureUrl") == null) {
			picture = "이미지 없음.jpg";
		}
		
%>
		<div class="goods border mr-3 mt-3">
			<div class="m-2">
				<img src="<%=picture %>" alt="사진" width="300px">
				<p>
					<h5 class="font-weight-bold"><%=res.getString("title") %></h5>
				</p>
				<p class="text-secondary"><%=res.getInt("price") %>원</p>
				<p class="nickname font-weight-bold"><%=res.getString("nickname") %></p>
			</div>
		 </div>
<%
	}
%>

</div>

<%
	// DB 연결 해제
	ms.disconnect();
%>