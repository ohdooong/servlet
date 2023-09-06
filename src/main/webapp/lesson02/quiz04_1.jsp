<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>길이 변환 결과</title>
		<!-- Bootstrap CDN -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
	</head>
	<body>
<%
	int length = Integer.valueOf(request.getParameter("length"));
	
	String[] choices = request.getParameterValues("distance");
	
	// 1cm = 0.393701in
	// 1cm = 0.010936yd
	// 1cm = 0.032808ft
	// 1cm = 0.01m

%>
	
	
		<div class="container">
			<h1>길이 변환 결과</h1>
			<h3><%=length %>cm</h3>
			<hr>
			<%
				
				if (choices != null) {
					String dist = "";
					for (String choice : choices) {
						double result = length;
						if (choice.equals("inch")){
							result *= 0.393701;
							dist = result + " in";
						} else if (choice.equals("yd")) {
							result *= 0.010936;
							dist = result + " yd";
						} else if (choice.equals("ft")) {
							result *= 0.032808;
							dist = result + " ft";
						} else if (choice.equals("meter")) {
							result *= 0.01;
							dist = result + " m";
						}
						
			%>
						<h2><%=dist %></h2>
			<%
					}
				}
			
			%>
		</div>
	</body>
</html>