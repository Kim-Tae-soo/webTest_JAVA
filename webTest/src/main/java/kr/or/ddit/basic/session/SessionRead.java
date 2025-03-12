package kr.or.ddit.basic.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Servlet implementation class SessionRead
 */
@WebServlet("/sessionRead.do")
public class SessionRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 저장된 Session 정보 읽어오기
		
		// 1. Session 객체를 생성하거나 현재 세션 가져오기
		HttpSession session = request.getSession();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Session pratice</title></head>");
		out.println("<body>");		
		out.println("<h3>Get each session data</h3>"); // 세션 데이터 각각 구하기
		/*
		  	2. 세션 객체의 getAttribute() 메서드
		  	형식 ) Session객체.getAttribute("key값");
		 */
		String testSession = (String)session.getAttribute("testSession");
		
		if(testSession == null) {
			out.println("<h4>There is no session data with key value 'testSession'.</h4>");
		} else {
			out.println("<h4>Session data with key value 'testSession' : " + testSession+ "</h4>");
		}
		
		out.println("<br><hr><br>");
		out.println("<h3>View full session data</h3>");
		// Session 객체의 전체 세션 key값을 가져오는 getAttributeName()메서드를 이용한다.
		Enumeration<String> sessionKeys = session.getAttributeNames();
		
		
		out.println("<ol>");
		int cnt = 0;
		while(sessionKeys.hasMoreElements()) {
			cnt ++;
			String key = sessionKeys.nextElement();
			out.println("<li>" + key + " : " + session.getAttribute(key) + "</li>");
		}
		if(cnt==0) 
			out.println("<li>There is no session data.</li>");
		
		out.println("</ol>");
		out.println("<br><hr><br>");
		
		//세션 ID ==> 세션을 구분하기 위한 고유한 값
		out.println("Session ID : " +session.getId() + "<br><br>");
		
		// 생성 시간 ==> 1970년 1월 1일부터 경과한 시간 (밀리세컨드 단위)
		out.println("Session creation time : " + session.getCreationTime() + "<br><br>");
		
		// 가장 최근에 세션에 접근한 시간 ==> 1970년 1월 1일부터 경과한 시간 (밀리세컨드 단위)
		out.println("The most recent time the session was accessed : " + session.getLastAccessedTime() + "<br><br>" );
		
		// 세션 유효 시간 ==> 초 단위
		out.println("Session validity time : " +  session.getMaxInactiveInterval() + "<br><br>");
		
		out.println("<br><br><br>");
		out.println("<a href='" + request.getContextPath()+"/basic/session/sessionTest.jsp'>Back Start Page</a>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
