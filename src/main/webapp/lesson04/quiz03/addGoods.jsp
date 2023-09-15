<%@page import="java.sql.ResultSet"%>
<%@page import="com.test.common.MysqlService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>물건 등록</title>

<!-- bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<style>
	<jsp:include page="style.jsp" />
</style>

</head>

<body>
<%
	// DB 연결
	MysqlService ms = MysqlService.getInstance();
	ms.connect();
	
	// select query
	String selectQuery = "select * from `seller`;";
	ResultSet res = ms.select(selectQuery);
	

%>


	<div class="container">
		
		<!-- 헤더 영역 -->
		<header class="header">
			<jsp:include page="header.jsp" />
		</header>
		
		<!-- 물건 올리기 -->
		<section class="contents bg-success">
			<div class="bg-light">
				<h1>물건 올리기</h1>
				<form>
					<div>
						<select>
							<option>-아이디 선택-</option>
<%
	while (res.next()) {
%>
							<option><%res.getString("nickname") %></option>
<%
	}
%>
						</select>
					</div>
					<textarea class="form-control"></textarea>
				
				</form>
			</div>
		</section>
		
		<!-- footer -->
		<footer class="d-flex align-items-center justify-content-center">
			<jsp:include page="footer.jsp" />
		</footer>
	
	</div>
	
<%
	// DB 연결 해제
	ms.disconnect();
%>
</body>
</html>