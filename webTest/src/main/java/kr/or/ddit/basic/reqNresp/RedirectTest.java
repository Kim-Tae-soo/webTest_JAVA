package kr.or.ddit.basic.reqNresp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;


@WebServlet("/redirectTest.do")
public class RedirectTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	
	- redirect 방식
		다른 페이지로 이동한다. 
		이 때 HttpServletRequest객체와 HttpServletResponse객체는 공유되지 않는다.
	- 작동 방식
		클라이언트가 '문서1'로 요청을 보내고 '문서1'의 응답시 브라우저에게 '이동할URL'을 전송하면
		브라우저가 자동으로 해당 URL로 재 요청하는 방식이다.
		이 때는 무조건 'GET'방식으로 요청하기 때문에 URL의 길이에 제한이 있다.
	*/
		
		// Request.setAttribute()메서드와 getAttribute()메서드를 이용해서 자료를 넘길 수 없다.
		//request.setAttribute("tel", "010-9999-9999");
		
		// Redirect 상식으로 이동하기  ==> Response객체의 sendRedirect()메서드를 이용한다.
		// 형식) Response객체.sendRedirect("이동할URL");
		// 		==> '이동할URL'은 '전체 URL 경로'를 지정해 주어야 한다.
		//		==> 그리고 URL 경로에 한글이 포함될 경우에는 URLEncoder.encode()메서드를 
		//			이용하여 인코딩해서 지정해 주어야 한다.
		//response.sendRedirect(request.getContextPath() + "/redirectTarget.do");
		
		// ---------------------------------------------------------
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// '문서1'에서 '문서2'로 데이터 보내기
		
		// 클라이언트가 보내온 데이터를 받는다.
		String userName = request.getParameter("username");
		
		// 전송할 데이터를 redirect의 URL주소 뒤에 붙여서 전송한다.
		response.sendRedirect(request.getContextPath() 
				+ "/redirectTarget.do?name=" + URLEncoder.encode(userName, "utf-8") 
				+ "&tel=010-9999-9999");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
