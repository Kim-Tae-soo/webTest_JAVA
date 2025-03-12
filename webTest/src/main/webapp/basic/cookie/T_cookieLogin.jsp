<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
   // 쿠키값으로 저장된 ID값 가져오기
   String cookieUserId = "";    // 쿠키값이 저장될 변수
   String chk = "";             // 체크박스의 체크 여부를 나타낼 변수
   // 쿠키 구하기
   Cookie[] cookieArr = request.getCookies();
   
   if(cookieArr!=null) {
      for(Cookie cookie : cookieArr) {
         if("username".equals(cookie.getName())){
            cookieUserId = cookie.getValue(); // 쿠키값(저장된 ID 값) 구하기
            chk = "checked";  // 체크 상태로 만들 값 저장
         }
      }
   }


%>
<body>
<body>
    <%-- <h2>로그인</h2>
    <form action ="<%=request.getContextPath()%>/cookieLoginServlet.do" method="post">
        <label for="username">사용자 이름:</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br><br>
        <input type = "checkbox" name ="check" value ="check">id 기억
        <input type="submit" value="login">
    </form> --%>
    
   <form action="<%=request.getContextPath()%>/T_cookieLoginServlet.do">
      <table style="margin:0 auto; border:1px solid; padding:15px;">
         <tr>
            <td> ID : </td>
            <td> <input type="text" name="username" value = "<%=cookieUserId %>" placeholder="ID 입력..."></td>
         </tr>
         <tr>
            <td> PASS : </td>
            <td> <input type="password" name="password" placeholder="Password 입력..."></td>
         </tr>
         <tr>
            <td colspan="2">
               <input type="checkbox" name="checkid" value="check" <%=chk %>>ID 기억하기
            </td>
         </tr>
         <tr>
            <td colspan="2" style="text-align:center;">
               <input type="submit" value="Login">
            </td>
         </tr>
         
      </table>

   </form>
</body>
</html>