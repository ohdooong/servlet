<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>제어문 활용</title>
	</head>
	<body>
<%
	// Map을 테이블로 표현
	// {"korean"=85, "english"=72, "math"=90, "science"=100}

	Map<String,Integer> scoreMap = new HashMap<>();
	scoreMap.put("korean",85);
	scoreMap.put("english",72);
	scoreMap.put("math",90);
	scoreMap.put("science",100);
	
	
%>
		<table border="1">
		<% 
			Iterator<String> iter = scoreMap.keySet().iterator(); 	// keySet은 인덱스가 존재하지 않기때문에 iterator로만 반복문을 돌려야함.
			while (iter.hasNext()) {
				String subject = iter.next();
				int score = scoreMap.get(subject);
		%>
		
			<tr>
				<th>
					<%
						if (subject.equals("korean")){
							out.print("국어");
						} else if (subject.equals("english")){
							out.print("영어");
						} else if (subject.equals("math")){
							out.print("수학");
						} else if (subject.equals("science")){
							out.print("과학");
						}
					%>
				</th>
				<td><%=score %></td>
			</tr>
		<%
			}
		%>
		</table>
	</body>
</html>