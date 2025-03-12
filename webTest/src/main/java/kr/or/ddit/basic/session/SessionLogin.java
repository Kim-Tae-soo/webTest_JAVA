package kr.or.ddit.basic.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/sessionLogin.do")
public class SessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 사용자가 입력한 ID와 PassWord를 받는다.
		String userId = request.getParameter("userid");
		String userPass = request.getParameter("userpass");
		
		HttpSession session = request.getSession();
		
		if("admin".equals(userId) && "1234".equals(userPass)) {
			// 로그인 성공...
			session.setAttribute("LOGINID", userId);
		}
		
		// session.jsp문서로 이동
		response.sendRedirect(request.getContextPath() + "/basic/session/sessionLogin.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
