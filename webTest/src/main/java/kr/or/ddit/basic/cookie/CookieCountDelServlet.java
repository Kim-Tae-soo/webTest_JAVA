package kr.or.ddit.basic.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookieCountDelServlet.do")
public class CookieCountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookieArr = request.getCookies();
		
		if(cookieArr != null) {
			for(Cookie cookie : cookieArr) {
				if("count".equals(cookie.getName())) {	// 'count'라는 쿠키 이름 찾기
					cookie.setMaxAge(0);	// 유지시간을 0으로 셋팅
					response.addCookie(cookie);	// 쿠키 덮어쓰기
				
				}
			}
		}
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Cookie Count test</title></head>");
		out.println("<body>");		
		out.println("<h3>count가 초기화 되었습니다.</h3>");
		out.println("<br><br><br><br>");
		out.println("<a href='" + request.getContextPath()+"/basic/cookie/cookieTest02.jsp'> 시작 페이지로 이동</a>&nbsp;&nbsp;&nbsp;" );
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
