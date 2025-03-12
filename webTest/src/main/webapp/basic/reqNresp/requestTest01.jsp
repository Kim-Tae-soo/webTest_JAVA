<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	HTML 주석
 -->
<%--
	JSP 주석
 --%>
 <%
 	// 이 영역은 JSP문서에서 JAVA코드를 작성할수 있는 영역입니다.
 	// 이 영역은 '스크립트릿 (scriptlet)'이라고 합니다.
 	
 	String name = "홍길동";
 %>
<%--
	<%= 변수나 수식 %> ==> JSP문서에서 '변수' 혹은 '수식'의 결과를 출력할 때 사용합니다.
					==> 이것을 '표현식(Expression)'이라고 합니다.
 --%>
 
 <!-- 
 	<form>태그의 속성들
 	1) action => <form>에서 구성한 데이터를 받아서 처리할 문서명 또는 서블릿 URL을 지정하는 속성
 	2) method => 전송방식 (GET , POST) => 기본 : GET
 	3) target => 응답이 나타날 프레임명을 지정한다
 	4) enctype => 서버로 파일을 전송할 때는 이 속성에 'multpart/form-data'로 지정해야한다.
  -->
 
 <h3><%=name %>의 Request 연습용 Form</h3>
<form action ="<%=request.getContextPath() %>/requestTest01.do" method="post">
<table border="1">
<tr>
   <td>이 름</td>
   <td><input type="text" name ="username" size ="10"></td>
</tr>
<tr>
   <td>직 업</td>
   <td>
      <select name="job">
         <option value ="무직">무직</option>
         <option value ="회사원">회사원</option>
         <option value ="전문직">전문직</option>
         <option value ="학생">학생</option>
      </select>
   </td>
</tr>

<tr>
   <td>취 미</td>
   <td>
      <input type="checkbox" name ="hobby" value ="여행">여행
      <input type="checkbox" name ="hobby" value ="독서">독서
      <input type="checkbox" name ="hobby" value ="게임">게임
      <input type="checkbox" name ="hobby" value ="테니스">테니스
      <input type="checkbox" name ="hobby" value ="배드민턴">배드민턴
   </td>
</tr>
<tr>
   <td colspan = "2" style ="text-align: center;">
      <input type ="submit" value ="전 송">
      <input type ="reset" value ="초기화">
   </td>
</tr>
</table>
</form>
 
</body>
</html>