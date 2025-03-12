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

button:hover {
	background-color: #0056b3;
}

a {
    text-decoration: none; /* 밑줄 제거 */
    color: inherit; /* 부모 색상 상속 */
}

a:hover {
    text-decoration: underline; /* 호버 시 강조 */
    color: #007BFF; /* 호버 시 색상 변경 */
}

</style>

<script>
	// 페이지 로드 후 메시지 표시
	window.onload = function() {
		const urlParams = new URLSearchParams(window.location.search);
		const loginStatus = urlParams.get('status'); // status 파라미터 가져오기

		if (loginStatus === 'success') {
			alert('로그인 성공! 환영합니다!');
		} else if (loginStatus === 'failure') {
			alert('로그인 실패! ID 또는 비밀번호를 확인하세요.');
		}
	};
</script>
</head>
<body>
	<form class="login-form" action="<%=request.getContextPath() %>/cookieLoginServlet.do" method="post">
		<%
		// 쿠키 검사
		String savedId = ""; // 기본 값은 빈 문자열
		boolean isRememberChecked = false;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("userId".equals(cookie.getName())) {
			savedId = cookie.getValue(); // 쿠키 값 설정
			isRememberChecked = true; // 체크박스 상태 설정
			break;
				}
			}
		}
		%>
		<div class="form-row">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" placeholder="ID 입력하세요." required>
    </div>
    <div class="form-row">
        <label for="password">PASS:</label>
        <input type="password" id="password" name="password" placeholder="PassWord 입력하세요." required>
    </div>
    <div class="checkbox-container">
        <input type="checkbox" id="remember-id" name="remember-id">
        <label for="remember-id">id 기억하기</label>
    </div>
    <button type="submit">Login</button>
</form>


</body>
</html>
