package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
// super class에서 Servlet 검색후 추가해서 생성
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 	서블릿이란 - 컨테이너(서블릿엔진)에 의해 관리되는 자바 기반의 웹 컴포넌트로서 동적인 웹 컨텐츠 생성을 가능하게 해준다.
 	
 	아래의 예제는 배포 서술사 (DD, Deployment Descriptor  - web.xml )를 이용해서 실행할 Servlet을 설정하여 처리하는 예제이다.
 */

// Servlet 클래스는 Httpservlet클래스를 상속해서 작성한다.
public class ServletTest01 extends HttpServlet {
	
	/*
	 *	http://localhost:80/webTest/servletTest01.do
	 *
	 *	- http 			==> 프로토콜
	 *	- localhost 	==> 도메인명(컴퓨티이름,ip주소)
	 *	- 80 			==> port번호 ( 웹에서는 80번호가 생략이 되어 보여짐 ) 
	 *	- webTest 		==> 컨텍스트 path( 보통 프로젝트의 이름으로 지정한다. )
	 *	- servletTest01.do==> 서블릿을 요청하는 URL패턴
	 */
	
	/*
	 *  이 서블릿 영역에서는 대 부분 service()메서드 또는 doGet()메서드, doPost()메서드를 재정의해서 작성한다.
	 *  
	 *  doGet()메서드나 doPost()메서드는 service() 메서드를 통해서 자동으로 호출된다.
	 *  
	 *  이 메서드의 매개변수로 HttpservletRequest객체와 HttpServletResponse객체가 사용된다.
	 *  - HttpServletRequest 객체 => 서비스 요청에 관련된 정보 및 메서드를 관리하는 객체
	 *  - HttpServletResponse 객체 => 서비스 응답에 관련된 정보 및 메서드를 관리하는 객체
	 */
	
	// doGet()메서드 ==> GET방식의 요청을 처리하는 메서드
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 위에서 처리한 내용을 Client에게 보내기 위해서 printwriter 객체를 생성한다.
		// (Response객체를 이용한다.)
		
		PrintWriter out = response.getWriter(); // 출력용 스트림 객체 (문자기반)
		
		// 처리하 내용을 출력한다.
		// 방법1) append()메서드 이용하기
		out.append("<html>")
			.append("<head>")
			.append("<meta charset='utf-8'>")
			.append("<title>첫번째 서블릿</title>")
			.append("</head>")
			.append("<body>")
			.append("<h2 style='text-align:center;'>안녕하세요 servlet 테스트 중입니다.</h2>")
			.append("</body>")
			.append("</html>");
			
		
	}
	
	// doPost()메서드 ==> POST방식의 요청을 처리하는 메서드
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
}
