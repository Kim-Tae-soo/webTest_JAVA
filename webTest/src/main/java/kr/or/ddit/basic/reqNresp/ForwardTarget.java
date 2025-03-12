package kr.or.ddit.basic.reqNresp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/forwardTarget.do")
public class ForwardTarget extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이 문서에서는 '문서1'에서 사용하던 Request객체와 Response객체를 같이 사용할 수 있다.
		// 그래서 클라이언트가 '문서1'로 보낸 데이터를 이 문서에서도 받을 수 있다.
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 파라미터 데이터 받기
		String userName = request.getParameter("username");
		
		// setAttribute()메서드로 저장한 데이터 받기 ==> 이 때 형변환이 필요하다.
		String tel = (String)request.getAttribute("tel");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'>"
							+ "<title>forward 연습</title></head>");
		out.println("<body>");
		out.println("<h3>forward 처리 결과</h3>");
		out.println("<table border='1'>");
		out.println("<tr><td>이 름</td>");
		out.println("<td>" + userName + "</td></tr>");
		out.println("<tr><td>전 화</td>");
		out.println("<td>" + tel + "</td></tr>");
		out.println("</table>");
		
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
