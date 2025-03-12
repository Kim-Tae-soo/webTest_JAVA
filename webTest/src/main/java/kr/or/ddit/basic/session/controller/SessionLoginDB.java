package kr.or.ddit.basic.session.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.basic.session.service.IMemberService;
import kr.or.ddit.basic.session.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class SessionLoginDB
 */
@WebServlet("/sessionLoginDB.do")
public class SessionLoginDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userid");
		String userPass = request.getParameter("userpass");
		
		// 사용자가 보낸 데이터를 VO에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(userId);
		memVo.setMem_pass(userPass);
		
		// Service 객체 생성
		IMemberService service = MemberServiceImpl.getInstance();
		
		// ID와 패스워드가 저장된 MemberVO 객체를 이용해서 DB에 해당하는 회원을 검색한다.
		MemberVO loginMember = service.getLoginMember(memVo);
		
		HttpSession session = request.getSession();
		
		// 로그인 성공 여부 검사
		if(loginMember != null) {
			session.setAttribute("LOGINMEMBER", loginMember);
		}
		
		response.sendRedirect(request.getContextPath() +
						"/basic/session/sessionLoginDB.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
