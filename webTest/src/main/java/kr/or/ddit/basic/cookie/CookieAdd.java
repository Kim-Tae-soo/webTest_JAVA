package kr.or.ddit.basic.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/cookieAdd.do")
public class CookieAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
	/*	
		Cookie 저장하는 방법
		
		1. Cookie객체를 생성한다.  ==> '쿠키이름'과 '쿠키값'을 문자열로 지정하여 생성한다.
		형식) Cookie cookie변수 = new Cookie("쿠키이름", "쿠키값");
		==> '쿠키값'으로 한글이 사용될 경우 URLEncode.encode()메서드로 인코딩 후 지정한다.
		==> 하나의 쿠키는 4KB(4096 bytes)까지 저장 가능하다.
		==> 하나의 도메인 당 20개 (총 300개)까지 저장 가능하다.
	*/
		Cookie nameCookie = new Cookie("name", "홍길동");
		Cookie ageCookie = new Cookie("age", "20");
//		Cookie ageCookie1 = new Cookie("age1", 20 + "");
//		Cookie ageCookie2 = new Cookie("age2", String.valueOf(20));
		Cookie genderCookie = new Cookie("gender", "Male");
		
	/*	
		2. 쿠키 속성 설정
		쿠키변수.setPath("적용경로"); ==> 지정된 경로와 그 하위 경로에서만 사용 가능하다.
								  ==> 생략하면 쿠키를 저장할 당시의 경로가 설정된다.
		쿠키변수.setMaxAge(유지시간); ==> 단위(초), 
						(-1:브라우저가 종료될 때까지 유지(기본값), 0: 즉시 삭제된다.)
		쿠키변수.setDomain("적용도메이명") ==> 예) ".ddit.or.kr" ==> www.ddit.or.kr, cafe.ddit.or.kr
		쿠키변수.setSecure(보안여부); ==> (true : 적용, false:미적용(기본값))
	*/
		
	/*	
		3. Response 객체를 이용하여 쿠키를 웹브라우저로 보내면 웹브라우저가 이 쿠키를 받아서 저장한다.
		형식) Response객체.addCookie(1번에서 만든 cookie객체)
	*/
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		response.addCookie(genderCookie);
		
		out.println("<html><head><meta charset='utf-8'>"
							+ "<title>Cookie 연습</title></head>");
		out.println("<body>");
		
		out.println("<h3>Cookie 데이터가 저장되었습니다.</h3>");
		out.println("<a href='" + request.getContextPath() 
							+ "/basic/cookie/cookieTest01.jsp'>시작문서로 가기</a>");
		
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
