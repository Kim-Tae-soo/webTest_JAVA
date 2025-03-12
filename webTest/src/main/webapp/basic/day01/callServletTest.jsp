<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 연습</title>
<script>
   window.onload = function(){
      document.getElementById("getBtn").addEventListener("click", function(){
         location.href = "http://localhost/webTest/ServletTest03.do";
      });   
   }
</script>
</head>
<body>
   <h2>Servlet 요청 연습</h2>
   <br><hr color="red"><br>
   
   <h3>GET 방식 요청하기 1 ==> 링크 방식</h3>
   <a href="http://localhost/webTest/ServletTest03.do">GET 방식 요청 1</a>
   <br><hr color="yellow"><br>
   
   <h3>GET 방식 요청하기 2 ==> form 태그의 method 속성을 생략하거나 'GET'으로 지정한 경우</h3>
   <form action="http://localhost/webTest/ServletTest03.do">
      <input type="submit" value="Get 방식 요청2" />
   </form>
   <br><hr color="green"><br>
   
   <h3>GET 방식 요청하기 3 ==> 'JavaScript'의 location.href속성을 이용한 경우</h3>
   <form >
      <input type="button" id="getBtn" value="Get 방식 요청3" />
   </form>
   <br><hr color="blue"><br>
   
   <h3>POST 방식 요청하기 ==> form 태그의 method속성을 'POST'로 지정한 경우</h3>
   <form action="http://localhost/webTest/ServletTest03.do" method="post">
      <input type="submit" value="Post 방식 요청" />
   </form>
   <br><hr color="purple"><br>
</body>
</html>