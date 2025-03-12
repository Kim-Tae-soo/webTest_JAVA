<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>cookieLogin</title>
<link rel="stylesheet" href="styles.css">
<style>
body {
	font-family: Arial, sans-serif;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
	background-color: #f4f4f9;
}

.login-container {
	text-align: center;
	background-color: #ffffff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

.login-form {
	display: flex;
	flex-direction: column;
	align-items: flex-start;
}

.form-row {
	display: flex;
	align-items: center;
	margin-bottom: 15px;
}

.form-row label {
	min-width: 80px; /* 라벨의 고정 너비 */
	font-weight: bold;
}

.form-row input {
	flex-grow: 1;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.checkbox-container {
	display: flex;
	align-items: center;
	margin-bottom: 15px;
}

.checkbox-container input {
	margin-right: 5px;
}

button {
	padding: 10px 20px;
	border: none;
	border-radius: 4px;
	background-color: #007BFF;
	color: white;
	cursor: pointer;
	font-weight: bold;
}

a {
    text-decoration: none; /* 밑줄 제거 */
    color: inherit; /* 부모 색상 상속 */
}

a:hover {
    text-decoration: underline; /* 호버 시 강조 */
    color: #007BFF; /* 호버 시 색상 변경 */
}


button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>


 
<a href="../cookie/cookieLogin.jsp "><h1>Cookie Logoin</h1> </a>

</body>
</html>
