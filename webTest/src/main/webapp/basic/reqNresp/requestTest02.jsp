<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/requestTest02.do" method="post">
    <hr>
    <h1>Request연습 Form(숫자 입력은 정수형으로 입력하세요.)</h1>
    <hr>
    <input type="number" name="num1" required>
    <select name="operator">
        <option value="plus">+</option>
        <option value="mus">-</option>
        <option value="multiply">*</option>
        <option value="ahr">/</option>
        <option value="skajwl">%</option>
    </select>
    <input type="number" name="num2" required>
    <input type="submit" value="확인">
</form>
</body>
</html>
