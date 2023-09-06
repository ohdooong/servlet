<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>계산기</title>
		<!-- Bootstrap CDN -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
	</head>
	<body>
		<div class="container">
			<h1>사칙 연산 계산기</h1>
			<form method="post" action="/lesson02/quiz05_1.jsp">
				<div class="d-flex ml-0">
					<div class="col-2 p-0">
						<input type="text" name="pre" class="form-control">
					</div>
					<div class="col-1">
						<select class="form-control" name="operation">
							<option>+</option>
							<option>-</option>
							<option>/</option>
							<option>*</option>						
						</select>
					</div>
					<div class="col-2 p-0">
						<input type="text" name="beh" class="form-control">
					</div>
					<div>
						<button type="submit" class="btn btn-success">계산하기</button>
					</div>
				</div>
			</form>
		</div>
		
		
		
		
	</body>
</html>