<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>forward, redirect 연습</h3>
<hr>

<form action="<%=request.getContextPath()%>/forwardTest.do">
	forward 방식 : <input type="text" name="username">
	<input type="submit" value="확인">
</form>
<hr>
<form action="<%=request.getContextPath()%>/redirectTest.do">
	redirect 방식 : <input type="text" name="username">
	<input type="submit" value="확인">
</form>



</body>
</html>