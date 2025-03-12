<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session login 연습</title>
</head>
<%
	// 로그인 정보가 저장된 Session 데이터를 구한다.
	MemberVO loginMemVo = (MemberVO)session.getAttribute("LOGINMEMBER");

%>
<body>
<%
	if(loginMemVo == null){
%>
<form action="<%=request.getContextPath()%>/sessionLoginDB.do">
      <table border="1" style="margin:0 auto;">
         <tr>
            <td> ID : </td>
            <td> <input type="text" name="userid" placeholder="ID 입력..."></td>
         </tr>
         <tr>
            <td> PASS : </td>
            <td> <input type="password" name="userpass" placeholder="Password 입력..."></td>
         </tr>
         <tr>
            <td colspan="2" style="text-align:center;">
               <input type="submit" value="Login">
            </td>
         </tr>
         
      </table>

   </form>
  <%
	} else{
		
  %>
  <div>  
  <h3><%=loginMemVo.getMem_name() %>님 반갑습니다.</h3><br><br>
  <a href="<%=request.getContextPath()%>/sessionLogoutDB.do">LOGOUT</a>
  </div>
  <%
	}
  %>
</body>
</html>