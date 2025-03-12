package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieCountServlet
 */
@WebServlet("/cookieCountServlet.do")
public class CookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 사용할 쿠키 이름 ==> count 
		// count라는 쿠기가 있는지 검사
		Cookie[] cookieArr = request.getCookies();
		int count = 0;	// 쿠키 이름이 저장될 변수
		
		if(cookieArr != null) {
			for(Cookie cookie : cookieArr) {
				if(cookie.getName().equals("count")){	// 쿠키 이름 찾기
					String value = cookie.getValue();	// 쿠키값(현재의 count값) 구하기
					count = Integer.parseInt(value);
				}
			}
		}
		
		count++;		//count값 증가
		
		// 증가된 count값을 '쿠키값'으로 갖는 Cookie객체 생성
		Cookie countCookie = new Cookie("count", String.valueOf(count));
		response.addCookie(countCookie);
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Cookie Count test</title></head>");
		out.println("<body>");		
		out.println("<h3>어서오세요. 당신은" + count + "번째 방문 입니다.</h3>");
		out.println("<br><br><br><br>");
		out.println("<a href='" + request.getContextPath()+"/cookieCountServlet.do'> 카운트 증가하기</a>&nbsp;&nbsp;&nbsp;" );
		out.println("<a href='" + request.getContextPath()+"/basic/cookie/cookieTest02.jsp'> 시작 페이지로 이동</a>&nbsp;&nbsp;&nbsp;" );
		out.println("</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
