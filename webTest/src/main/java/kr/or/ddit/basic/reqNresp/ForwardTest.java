package kr.or.ddit.basic.reqNresp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/forwardTest.do")
public class ForwardTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	
	- forward 방식
		특정 서블릿이나 JSP에 대한 요청을 다른 서블릿이나 JSP로 넘긴다.
		(이 때 HttpServletRequest객체와 HttpServletResponse객체를 공유한다.)
		클라이언트에 나타나는 URL주소는 처음 요청할 때의 주소가 바뀌지 않으며, redirect보다 성능이 좋다.
		단, 같은 서버 내부에서만 접근이 가능하다.
		
	- 이동시키는 페이지(문서1)에서 이동되는 페이지(문서2)로 데이터를 보내는 방법
	  ==> '문서1'에서 Request객체의 setAttribute()메서드를 이용하여 데이터를 셋팅하여 보내고
	   	  '문서2'에서 Request객체의 getAttribute()메서드를 이용하여 데이터를 읽어온다.
	   	  
	  ==> 보낼때 형식) Request객체.setAttribute("key값", 저장할데이터);
	   	   		--> 'key값'은 문자열로 지정하고 '저장할데이터' java의 모든 자료형을 지정할 수 있다.
	   	   		
	  ==> 받을때 형식) Request객체.getAtrribute("key값"); 	   		
	*/
		request.setAttribute("tel", "010-1234-5678");
		
	// forward 방식으로 이동하기
	//  ==> Request객체의 getRequestDispatcher()메서드에 '이동할 서블릿이나 JSP'를 지정해
	//		주는데 전체 URI 경로 중에서 ContextPath 이후의 경로를 지정해 준다.
	// 	예) 이동할 URI주소가 'http://IP주소/컨텍스트패스/경로/문서명'일 경우
	//			==> '/경로/문서명'까지만 지정한다.
		
		// http://localhost/webTest/forwardTarget.do 로 이동하기
		RequestDispatcher rd = request.getRequestDispatcher("/forwardTarget.do");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
