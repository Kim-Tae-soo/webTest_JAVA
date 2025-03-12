package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sessionAdd.do")
public class SessionAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		/*
		 	- Session 저장하는 방법
		 	
		 	1. Session객체를 생성하거나 현재 세션 정보를 가져온다.
		 		형식1 ) Request객체.getSession(); 또는 Request객체.getSession(true);
		 			==> 현재 세션이 존재하면 현재 세션을 반환하고, 존재하지 않으면 새로운 세션을 생성한다.
		 		형식2 ) Request객체.getSession(false);
		 			==> 현재 세션이 존재하면 현재 세션을 반환한고, 존재하지 않으면 새로운 세션을 생성하지 않고 null을 반환한다.
		 		
		 		
		 */
			HttpSession session = request.getSession();
			
		/*
		 	2. setArreibute()메서드를 이용하여 Session에 데이터를 저장한다.
		 	형식) Session객체.setAttribute("ket값", 데이터)
		 		==> 'key값'은 문자열, '데이터'는 자바의 모든 자료를 지정할 수 있다.
		 */
			session.setAttribute("testSession", "practice Session");
			session.setAttribute("userName", "이성화");
			session.setAttribute("age", 99);
			
			out.println("<html><head><meta charset='utf-8'>");
			out.println("<title>Seesion practice</title></head>");
			out.println("<body>");		
			out.println("<h3>Save Seesion Data</h3>");
			out.println("<br><br><br>");
			out.println("<a href='" + request.getContextPath()+"/basic/session/sessionTest.jsp'>Back Start Page</a>");
			out.println("</body></html>");
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
