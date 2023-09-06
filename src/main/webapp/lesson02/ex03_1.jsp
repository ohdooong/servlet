<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>결과</title>
	</head>
	<body>
<%
	String nickname = request.getParameter("nickname");
	String hobby = request.getParameter("hobby");
	String animal = request.getParameter("animal"); // 강아지 or 고양이가 저장
	
	// 여러 선택 다 받아오기 (체크박스)
	String[] foodArr = request.getParameterValues("food"); // 선택 항목 값이 여러개일 때
	
	String fruit = request.getParameter("fruit"); // 과일명		
%>	
		<table border="1">
			<tr>
				<th>별명</th>
				<td><%=nickname %></td>
			</tr>
			<tr>
				<th>취미</th>
				<td><%=hobby %></td>
			</tr>
			<tr>
				<th>선호하는 동물</th>
				<td><%=animal %></td>
			</tr>
			<tr>
				<th>선호하는 과일</th>
				<td><%=fruit %></td>
			</tr>
			<tr>
				<th>선호하는 음식</th>
				<td>
					<%
					// 피자, 번데기, 민트초코
						if(foodArr != null) {
							String result = ""; // null은 method가 존재하지않는다. , ""은 메소드 존재
							for (String food : foodArr) { // 배열이 null이면 에러가 난다.
								result += food + ",";
							}
							// 맨 뒤에 붙은 콤마 제거
							result = result.substring(0,result.length() - 1);
							out.print(result);
						}
					%>
				</td>
			</tr>
			
			
		</table>
	
	</body>
</html>